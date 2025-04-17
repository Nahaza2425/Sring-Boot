package com.clotfilms.service;

import java.util.List;
import java.util.Optional;

import com.clotfilms.repository.PeliculaRepository;
import org.springframework.stereotype.Service;
import com.clotfilms.model.Pelicula;



@Service
public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> obtenerPelicula(String id) {
        return peliculaRepository.findById(id);
    }

    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public void eliminarPelicula(String id) {
        peliculaRepository.deleteById(id);
    }
}
