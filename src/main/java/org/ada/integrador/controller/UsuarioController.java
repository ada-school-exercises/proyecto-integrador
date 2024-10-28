package org.ada.integrador.controller;

import org.ada.integrador.bo.Usuario;
import org.ada.integrador.service.usuario.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable String idUsuario) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(idUsuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable String idUsuario, @RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.modificarUsuario(idUsuario, usuario);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
