package org.ada.integrador.service.autenticacion;

import org.ada.integrador.bo.Usuario;
import org.ada.integrador.config.JwtService;
import org.ada.integrador.repository.UsuarioRepositoryMongo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService {

    private UsuarioRepositoryMongo usuarioRepositoryMongo;
    private JwtService jwtService;

    public AutenticacionService(UsuarioRepositoryMongo usuarioRepositoryMongo, JwtService jwtService) {
        this.usuarioRepositoryMongo = usuarioRepositoryMongo;
        this.jwtService = jwtService;
    }

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public String login(String correo, String password) {
        Usuario usuario = usuarioRepositoryMongo.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (usuario != null && passwordEncoder.matches(password, usuario.getContrasena())) {
            System.out.println(usuario);
            return jwtService.generateToken(usuario.getIdUsuario());
        } else {
            throw new RuntimeException("Crendenciales inválidas");
        }
    }
}
