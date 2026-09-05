package com.example.demo.controller;

import com.example.demo.repository.HorarioRepository;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {


    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private HorarioRepository horarioRepository;

   
    @GetMapping("/professor")
    public String buscarPorProfessor(Model model) {
        
        model.addAttribute("professores", professorRepository.findAll());
        return "consulta-professor"; 
    }

  
    @GetMapping("/professor/{id}")
    public String resultadoProfessor(@PathVariable Long id, Model model) {
        model.addAttribute("professor", professorRepository.findById(id).orElse(null));
        model.addAttribute("horarios", horarioRepository.findByProfessorId(id));
        return "resultado-professor"; 
    }

   

    @GetMapping("/turma")
    public String buscarPorTurma(Model model) {
        model.addAttribute("turmas", turmaRepository.findAll());
        return "consulta-turma";
    }

    @GetMapping("/turma/{id}")
    public String resultadoTurma(@PathVariable Long id, Model model) {
        model.addAttribute("turma", turmaRepository.findById(id).orElse(null));
        model.addAttribute("horarios", horarioRepository.findByTurmaId(id));
        return "resultado-turma";
    }
}
