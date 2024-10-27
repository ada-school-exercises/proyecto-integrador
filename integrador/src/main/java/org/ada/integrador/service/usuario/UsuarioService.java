package org.ada.integrador.service.usuario;

import org.ada.integrador.bo.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Usuario buscarUsuarioPorId(Long idUsuario);
    List<Usuario> listarUsuarios();
    Usuario modificarUsuario(Long idUsuario, Usuario usuario);
    void eliminarUsuario(Long idUsuario);
}
