package com.betpoli.betpoli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.betpoli.betpoli.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCedulaAndContrasena(String cedula, String contrasena);
    Usuario findByCedula(String cedula);
}

