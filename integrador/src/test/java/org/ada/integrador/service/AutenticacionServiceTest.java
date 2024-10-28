package org.ada.integrador.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.ada.integrador.bo.Usuario;
import org.ada.integrador.config.JwtService;
import org.ada.integrador.repository.UsuarioRepositoryMongo;
import org.ada.integrador.service.autenticacion.AutenticacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

class AutenticacionServiceTest {

    @Mock
    private UsuarioRepositoryMongo usuarioRepositoryMongo;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AutenticacionService autenticacionService;

    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    void testLoginUsuarioExistenteContrasenaValida() {
        String correo = "usuario@ejemplo.com";
        String password = "contrasena";
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("1");
        usuario.setCorreo(correo);
        usuario.setContrasena(passwordEncoder.encode(password));

        when(usuarioRepositoryMongo.findByCorreo(correo)).thenReturn(Optional.of(usuario));
        when(jwtService.generateToken(usuario.getIdUsuario())).thenReturn("tokenJWT123");

        String token = autenticacionService.login(correo, password);

        assertEquals("tokenJWT123", token);
        verify(usuarioRepositoryMongo).findByCorreo(correo);
        verify(jwtService).generateToken(usuario.getIdUsuario());
    }

    @Test
    void testLoginUsuarioNoEncontrado() {
        String correo = "inexistente@ejemplo.com";
        String password = "contrasena";

        when(usuarioRepositoryMongo.findByCorreo(correo)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () ->
                autenticacionService.login(correo, password)
        );

        assertEquals("Usuario no encontrado", exception.getMessage());
    }

    @Test
    void testLoginContrasenaInvalida() {
        String correo = "usuario@ejemplo.com";
        String password = "contrasenaIncorrecta";
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("1");
        usuario.setCorreo(correo);
        usuario.setContrasena(passwordEncoder.encode("contrasena"));

        when(usuarioRepositoryMongo.findByCorreo(correo)).thenReturn(Optional.of(usuario));

        Exception exception = assertThrows(RuntimeException.class, () ->
                autenticacionService.login(correo, password)
        );

        assertEquals("Crendenciales inválidas", exception.getMessage());
    }
}
