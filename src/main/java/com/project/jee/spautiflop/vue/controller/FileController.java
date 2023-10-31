package com.project.jee.spautiflop.vue.controller;

import com.project.jee.spautiflop.model.LocalUser;
import com.project.jee.spautiflop.service.FileService;
import com.project.jee.spautiflop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownServiceException;

@RestController
@RequestMapping("/api/file")
public class FileController {


    private final UserService userService;
    private final FileService fileService;

    public FileController(UserService userService, FileService fileService)
    {
        this.userService = userService;
        this.fileService = fileService;
    }

    @GetMapping("/image/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource file;
        try {
            file =  fileService.retreiveFile(fileService.retrieveAbsolutePathImage(filename));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("/audio/{filename:.+}")
    public ResponseEntity<Resource> getMusic(@PathVariable String filename) {
        Resource file;
        try {
            file =  fileService.retreiveFile(fileService.retrieveAbsolutePathMusic(filename));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
