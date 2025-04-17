package com.clotfilms.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.clotfilms.model.Pelicula;
import com.clotfilms.service.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    // Mostrar listado de películas
    @GetMapping
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        return "peliculas/listado";
    }

    // Formulario para agregar una nueva película
    @GetMapping("/nuevo")
    public String nuevaPelicula(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/formulario";
    }

    // Guardar nueva película
    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.guardarPelicula(pelicula);
        return "redirect:/peliculas";
    }

    // Editar película
    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable String id, Model model) {
        Optional<Pelicula> peliculaOpt = peliculaService.obtenerPelicula(id);
        if (peliculaOpt.isPresent()) {
            model.addAttribute("pelicula", peliculaOpt.get());
            return "peliculas/formulario";
        }
        return "redirect:/peliculas";
    }

    // Eliminar película
    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable String id) {
        peliculaService.eliminarPelicula(id);
        return "redirect:/peliculas";
    }
}
