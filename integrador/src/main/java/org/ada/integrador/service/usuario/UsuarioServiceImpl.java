package org.ada.integrador.service.usuario;

import org.ada.integrador.bo.Usuario;
import org.ada.integrador.repository.UsuarioRepositoryMongo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepositoryMongo usuarioRepositoryMongo;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsuarioServiceImpl(UsuarioRepositoryMongo usuarioRepositoryMongo) {
        this.usuarioRepositoryMongo = usuarioRepositoryMongo;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuarioRepositoryMongo.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorId(String idUsuario) {
        return usuarioRepositoryMongo.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositoryMongo.findAll();
    }

    @Override
    public Usuario modificarUsuario(String idUsuario, Usuario usuario) {
        Usuario usuarioEncontrado = usuarioRepositoryMongo.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        usuarioEncontrado.setNombre(usuario.getNombre());
        usuarioEncontrado.setApellido(usuario.getApellido());
        usuarioEncontrado.setUsuario(usuario.getUsuario());
        usuarioEncontrado.setCorreo(usuario.getCorreo());
        return usuarioRepositoryMongo.save(usuarioEncontrado);
    }

    @Override
    public void eliminarUsuario(String idUsuario) {
        usuarioRepositoryMongo.deleteById(idUsuario);
    }
}
