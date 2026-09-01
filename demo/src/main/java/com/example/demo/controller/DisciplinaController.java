package com.example.demo.controller;

import com.example.demo.model.Disciplina;
import com.example.demo.repository.DisciplinaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository repository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("disciplinas", repository.findAll());
        return "lista-disciplinas";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "form-disciplina";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Disciplina disciplina, BindingResult result) {
        if (result.hasErrors()) return "form-disciplina";
        repository.save(disciplina);
        return "redirect:/disciplinas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("disciplina", repository.findById(id).orElseThrow());
        return "form-disciplina";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/disciplinas";
    }
}