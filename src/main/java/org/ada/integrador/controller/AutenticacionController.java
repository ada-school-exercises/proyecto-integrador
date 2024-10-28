package org.ada.integrador.controller;

import org.ada.integrador.bo.Usuario;
import org.ada.integrador.dto.Login;
import org.ada.integrador.service.autenticacion.AutenticacionService;
import org.ada.integrador.service.usuario.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/autenticacion")
public class AutenticacionController {

    private final AutenticacionService autenticacionService;
    private final UsuarioService usuarioService;

    public AutenticacionController(AutenticacionService autenticacionService, UsuarioService usuarioService) {
        this.autenticacionService = autenticacionService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @PostMapping("/ingreso")
    public String login(@RequestBody Login login) {
        return autenticacionService.login(login.getCorreo(), login.getContrasena());
    }
}
