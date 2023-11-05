package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.service.SearchService;
import com.project.jee.spautiflop.vue.model.SearchDataResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = "/{query}")
    public ResponseEntity<SearchDataResponse> search(@PathVariable("query") @Valid @RequestBody @ModelAttribute String query) {
        try {
            return ResponseEntity.ok(this.searchService.search(query));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
    }
}
