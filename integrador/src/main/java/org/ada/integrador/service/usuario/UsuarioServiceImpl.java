package org.ada.integrador.service.usuario;

import org.ada.integrador.bo.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final HashMap<Long, Usuario> usuarios = new HashMap<>();
    private Long id = 0L;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        usuario.setIdUsuario(id++);
        usuarios.put(usuario.getIdUsuario(), usuario);
        return usuario;
    }

    @Override
    public Usuario buscarUsuarioPorId(Long idUsuario) {
        return usuarios.get(idUsuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios.values());
    }

    @Override
    public Usuario modificarUsuario(Long idUsuario, Usuario usuario) {
        if(usuarios.containsKey(idUsuario)) {
            usuario.setIdUsuario(idUsuario);
            usuarios.put(idUsuario, usuario);
            return usuario;
        }
        throw new IllegalArgumentException("No existe un usuario con ese id");
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        usuarios.remove(idUsuario);
    }
}
