package com.project.jee.spautiflop.vue.model;

import com.project.jee.spautiflop.model.LocalUser;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class PlaylistRegisterBody {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 250)
    private String name;

    private MultipartFile image;
}
