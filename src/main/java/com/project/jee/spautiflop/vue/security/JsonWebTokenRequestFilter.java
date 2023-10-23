package com.project.jee.spautiflop.vue.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.model.repo.UserRepository;
import com.project.jee.spautiflop.service.JsonWebTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class JsonWebTokenRequestFilter extends OncePerRequestFilter {

  private final JsonWebTokenService jwtService;
  private final UserRepository userRepository;

  public JsonWebTokenRequestFilter(JsonWebTokenService JsonWebTokenService, UserRepository userRepository) {
    this.jwtService = JsonWebTokenService;
    this.userRepository = userRepository;
  }

  /* what this method really do is to check if every request contains a token, and if it does, it will try to authenticate the user
   * by setting the authentication in the SecurityContext
   * to be fair, I don't really understand how it works, but it does, so I'm not gonna complain
   * but now we can use the @AuthenticationPrincipal annotation in our controllers to get the current user who made the request super fast yeah !
   * */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String token = request.getHeader("Authorization");

    if (token != null && token.startsWith("Bearer ")) {
      token = token.substring(7);

      try {
        String pseudo = jwtService.getPseudoFromToken(token);
        Optional<LocalUser> opUser = userRepository.findByPseudoIgnoreCase(pseudo);
        if (opUser.isPresent()) {
          LocalUser user = opUser.get();
          UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
          SecurityContextHolder.getContext().setAuthentication(authentication);
        }
      } catch (JWTDecodeException ex) {
        // we do nothing, the token is invalid / we don't care about it
      }
    }

    filterChain.doFilter(request, response);
  }
}
