package com.example.demo.controller;

import com.example.demo.model.Horario;
import com.example.demo.repository.HorarioRepository;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.repository.TurmaRepository;
import com.example.demo.repository.DisciplinaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/horarios")
public class HorarioController {

    @Autowired private HorarioRepository horarioRepository;
    @Autowired private ProfessorRepository professorRepository;
    @Autowired private TurmaRepository turmaRepository;
    @Autowired private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("horarios", horarioRepository.findAll());
        return "lista-horarios";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("horario", new Horario());
        carregarListas(model); // Carrega opções pro formulário
        return "form-horario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Horario horario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            carregarListas(model); // Se der erro, recarrega as listas pro select não quebrar
            return "form-horario";
        }
        horarioRepository.save(horario);
        return "redirect:/horarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("horario", horarioRepository.findById(id).orElseThrow());
        carregarListas(model);
        return "form-horario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        horarioRepository.deleteById(id);
        return "redirect:/horarios";
    }

    // Método auxiliar para não repetir código
    private void carregarListas(Model model) {
        model.addAttribute("professores", professorRepository.findAll());
        model.addAttribute("turmas", turmaRepository.findAll());
        model.addAttribute("disciplinas", disciplinaRepository.findAll());
    }
}