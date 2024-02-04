package org.liafuture.testament.controller;

import org.liafuture.testament.dto.response.UserDTO;
import org.liafuture.testament.service.UserService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.File;
import java.nio.file.Files;
import java.util.Base64;

/**
 * Controller to Handle Users Information
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    private UserController(final UserService userService) {
        this.userService = userService;
    }
    /*
    TODO
    ENDPOINTS

    POST /user/signup
    POST /user/login


    GET /user/{id}
    PUT /user/{id}

     */



    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(final @RequestBody UserDTO request) {
        final UserDTO response = this.userService.saveUser(request);

        return ResponseEntity.ok(response);
    }



    @GetMapping("/mostrar")
    public String mostrarAudio(Model model) {
        File archivo = new File("src/main/resources/car.mp3");

        String base64Converted = "";

        try {
            byte[] archivoEnBytes = Files.readAllBytes(archivo.toPath());

            base64Converted = Base64.getEncoder().encodeToString(archivoEnBytes);

        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("audioFromJava", base64Converted);

        return "Audio";
    }
}
