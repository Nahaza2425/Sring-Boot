package com.clotfilms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.clotfilms.model.Pelicula;

public interface PeliculaRepository extends MongoRepository<Pelicula, String> {
    // Puedes definir métodos de consulta personalizados si es necesario
}
