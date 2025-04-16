package com.informaticonfig.biblioteca.controller;

import com.informaticonfig.biblioteca.model.Autor;
import com.informaticonfig.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping("/exer2")
    public String mostrarFormulario(Model model) {
    model.addAttribute("autor", new Autor());
    model.addAttribute("autores", autorRepository.findAll());
    return "index"; // Carga el archivo index.html desde templates
}

    @PostMapping("/guardarAutor")
    public String guardarAutor(@ModelAttribute Autor autor) {
    autorRepository.save(autor);
    return "redirect:/exer2"; // Redirige a /exer2 después de guardar
}
}