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

    // O Autowired liga o nosso controlador com os repositórios que você criou antes
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    // --- VISUALIZAÇÃO POR PROFESSOR ---

    // 1. Abre a tela para o usuário escolher um professor na lista
    @GetMapping("/professor")
    public String buscarPorProfessor(Model model) {
        // Pega todos os professores do banco e envia para a tela HTML
        model.addAttribute("professores", professorRepository.findAll());
        return "consulta-professor"; 
    }

    // 2. Mostra a tabela de horários daquele professor específico que foi clicado
    @GetMapping("/professor/{id}")
    public String resultadoProfessor(@PathVariable Long id, Model model) {
        model.addAttribute("professor", professorRepository.findById(id).orElse(null));
        model.addAttribute("horarios", horarioRepository.findByProfessorId(id));
        return "resultado-professor"; 
    }

    // --- VISUALIZAÇÃO POR TURMA ---

    // 3. Abre a tela para o usuário escolher uma turma na lista
    @GetMapping("/turma")
    public String buscarPorTurma(Model model) {
        model.addAttribute("turmas", turmaRepository.findAll());
        return "consulta-turma";
    }

    // 4. Mostra a tabela de horários daquela turma específica que foi clicada
    @GetMapping("/turma/{id}")
    public String resultadoTurma(@PathVariable Long id, Model model) {
        model.addAttribute("turma", turmaRepository.findById(id).orElse(null));
        model.addAttribute("horarios", horarioRepository.findByTurmaId(id));
        return "resultado-turma";
    }
}