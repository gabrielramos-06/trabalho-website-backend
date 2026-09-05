package com.example.demo.controller;

import com.example.demo.model.Professor;
import com.example.demo.repository.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("professores", repository.findAll());
        return "lista-professores";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("professor", new Professor());
        return "form-professor";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Professor professor, BindingResult result) {
        if (result.hasErrors()) {
            return "form-professor";
        }
        repository.save(professor);
        return "redirect:/professores"; 
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("professor", repository.findById(id).orElseThrow());
        return "form-professor";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/professores";
    }
}
