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

    // Tela de listagem (Lê os dados)
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("professores", repository.findAll());
        return "lista-professores";
    }

    // Tela de formulário vazio (Criar)
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("professor", new Professor());
        return "form-professor";
    }

    // Ação de salvar no banco (Garante a validação com @Valid)
    @PostMapping("/salvar")
    public String salvar(@Valid Professor professor, BindingResult result) {
        if (result.hasErrors()) {
            return "form-professor"; // Volta pro formulário se houver erro (ex: nome vazio)
        }
        repository.save(professor);
        return "redirect:/professores"; // Redireciona para a lista após salvar
    }

    // Tela de edição com os dados preenchidos (Atualizar)
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("professor", repository.findById(id).orElseThrow());
        return "form-professor";
    }

    // Ação de exclusão (Deletar)
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/professores";
    }
}