package org.ada.integrador.service.usuario;

import org.ada.integrador.bo.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Usuario buscarUsuarioPorId(String idUsuario);
    List<Usuario> listarUsuarios();
    Usuario modificarUsuario(String idUsuario, Usuario usuario);
    void eliminarUsuario(String idUsuario);
}
