// LoginController.java
package com.betpoli.betpoli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.betpoli.betpoli.model.Usuario;
import com.betpoli.betpoli.service.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarPaginaLogin() {
        return "login";
    }

    @GetMapping("/registro")
    public String mostrarPaginaRegistro() {
        return "registro";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String cedula, @RequestParam String contrasena, Model model) {
        try {
            Usuario usuario = usuarioService.autenticarUsuario(cedula, contrasena);

            if (usuario != null) {
                // Usuario autenticado, puedes redirigir a la página de usuario
                return "redirect:/usuario";
            } else {
                // Autenticación fallida, puedes mostrar un mensaje de error
                model.addAttribute("error", "Cédula o contraseña incorrecta");
                return "login";
            }
        } catch (Exception e) {
            // Manejo de excepciones, loggear el error
            e.printStackTrace();
            model.addAttribute("error", "Error en la autenticación");
            return "login";
        }
    }

    @PostMapping("/registro")
    public String procesarRegistro(@RequestParam String nombre, @RequestParam String apellido,
                                   @RequestParam String cedula, @RequestParam String correo,
                                   @RequestParam String contrasena, Model model) {
        try {
            Usuario nuevoUsuario = new Usuario(nombre, apellido, cedula, correo, contrasena);
            Usuario usuarioRegistrado = usuarioService.registrarUsuario(nuevoUsuario);

            if (usuarioRegistrado != null) {
                // Registro exitoso, redirige a la página de inicio de sesión
                return "redirect:/login";
            } else {
                // Usuario ya existe, puedes mostrar un mensaje de error
                model.addAttribute("error", "El usuario ya existe");
                return "registro";
            }
        } catch (Exception e) {
            // Manejo de excepciones, loggear el error
            e.printStackTrace();
            model.addAttribute("error", "Error en el registro"+ e.getMessage());
            return "registro";
        }
    }
}
