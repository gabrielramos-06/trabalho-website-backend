package com.example.demo.controller;

import com.example.demo.model.Turma;
import com.example.demo.repository.TurmaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("turmas", repository.findAll());
        return "lista-turmas";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("turma", new Turma());
        return "form-turma";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Turma turma, BindingResult result) {
        if (result.hasErrors()) return "form-turma";
        repository.save(turma);
        return "redirect:/turmas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("turma", repository.findById(id).orElseThrow());
        return "form-turma";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/turmas";
    }
}