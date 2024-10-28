package org.ada.integrador.repository;

import org.ada.integrador.bo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepositoryMongo extends MongoRepository<Usuario, String> {
}
