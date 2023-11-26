// PageController.java
package com.betpoli.betpoli;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/usuario")
    public String mostrarPaginaUsuario() {
        return "usuario";
    }


    @GetMapping("/apuestas")
    public String mostrarPaginaApuestas() {
        return "apuestas";
    }

    @GetMapping("/sorteos")
    public String mostrarPaginaSorteos() {
        return "sorteos";
    }

    @GetMapping("/rifas")
    public String mostrarPaginaRifas() {
        return "rifas";
    }

    @GetMapping("/adminDeportes")
    public String mostrarPaginaAdminDeportes() {
        return "adminDeportes";
    }
}
