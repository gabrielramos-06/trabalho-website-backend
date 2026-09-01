package com.example.demo.repository;

import com.example.demo.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    
    // O sistema entende sozinho que deve buscar horários pelo ID do professor
    List<Horario> findByProfessorId(Long professorId);
    
    // O sistema entende sozinho que deve buscar horários pelo ID da turma
    List<Horario> findByTurmaId(Long turmaId);
}