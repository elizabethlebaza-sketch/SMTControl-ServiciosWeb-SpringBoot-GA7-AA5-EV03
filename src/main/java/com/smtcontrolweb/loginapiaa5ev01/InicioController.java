package com.smtcontrolweb.loginapiaa5ev01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    @GetMapping("/")
    public String inicio() {
        return "SMTControl API - Servicio funcionando correctamente";
    }
}