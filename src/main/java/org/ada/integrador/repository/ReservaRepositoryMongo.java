package org.ada.integrador.repository;

import org.ada.integrador.bo.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepositoryMongo extends MongoRepository<Reserva, String> {
}
