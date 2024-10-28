package org.ada.integrador.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.ada.integrador.bo.Usuario;
import org.ada.integrador.repository.UsuarioRepositoryMongo;
import org.ada.integrador.service.usuario.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepositoryMongo usuarioRepositoryMongo;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearUsuario() {
        Usuario usuario = new Usuario();
        usuario.setContrasena("password");

        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");
        when(usuarioRepositoryMongo.save(any(Usuario.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Usuario resultado = usuarioService.crearUsuario(usuario);

        assertNotEquals("password", resultado.getContrasena());
        verify(usuarioRepositoryMongo).save(usuario);
    }


    @Test
    void testBuscarUsuarioPorId() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("1");

        when(usuarioRepositoryMongo.findById("1")).thenReturn(Optional.of(usuario));

        Usuario resultado = usuarioService.buscarUsuarioPorId("1");

        assertEquals("1", resultado.getIdUsuario());
        verify(usuarioRepositoryMongo).findById("1");
    }

    @Test
    void testBuscarUsuarioPorIdNotFound() {
        when(usuarioRepositoryMongo.findById("1")).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                usuarioService.buscarUsuarioPorId("1")
        );

        assertEquals("Usuario no encontrado", exception.getMessage());
    }

    @Test
    void testListarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario());

        when(usuarioRepositoryMongo.findAll()).thenReturn(usuarios);

        List<Usuario> resultado = usuarioService.listarUsuarios();

        assertEquals(1, resultado.size());
        verify(usuarioRepositoryMongo).findAll();
    }

    @Test
    void testModificarUsuario() {
        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setIdUsuario("1");

        Usuario usuarioModificado = new Usuario();
        usuarioModificado.setNombre("NuevoNombre");

        when(usuarioRepositoryMongo.findById("1")).thenReturn(Optional.of(usuarioExistente));
        when(usuarioRepositoryMongo.save(any(Usuario.class))).thenReturn(usuarioModificado);

        Usuario resultado = usuarioService.modificarUsuario("1", usuarioModificado);

        assertEquals("NuevoNombre", resultado.getNombre());
        verify(usuarioRepositoryMongo).findById("1");
        verify(usuarioRepositoryMongo).save(usuarioExistente);
    }

    @Test
    void testEliminarUsuario() {
        String idUsuario = "1";

        doNothing().when(usuarioRepositoryMongo).deleteById(idUsuario);

        usuarioService.eliminarUsuario(idUsuario);

        verify(usuarioRepositoryMongo).deleteById(idUsuario);
    }
}

