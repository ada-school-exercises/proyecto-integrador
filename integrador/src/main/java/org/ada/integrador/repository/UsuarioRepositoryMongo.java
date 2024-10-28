package org.ada.integrador.repository;

import org.ada.integrador.bo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepositoryMongo extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByCorreo(String correo);
}
