package com.betpoli.betpoli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.betpoli.betpoli.repository.UsuarioRepository;
import com.betpoli.betpoli.model.Usuario;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticarUsuario(String cedula, String contrasena) {
        return usuarioRepository.findByCedulaAndContrasena(cedula, contrasena);
    }

    public Usuario registrarUsuario(Usuario usuario) {
        // Verificar si el usuario ya existe por su cédula
        if (usuarioRepository.findByCedula(usuario.getCedula()) == null) {
            // El usuario no existe, entonces podemos guardarlo
            return usuarioRepository.save(usuario);
        } else {
            // El usuario ya existe, puedes manejar esto de acuerdo a tus necesidades
            // Por ejemplo, lanzar una excepción, mostrar un mensaje, etc.
            return null;
        }
    }
}
