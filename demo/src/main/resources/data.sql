-- Criando professores
INSERT INTO professor (nome) VALUES ('João Silva');
INSERT INTO professor (nome) VALUES ('Maria Souza');

-- Criando turmas
INSERT INTO turma (codigo) VALUES ('SI-1A');
INSERT INTO turma (codigo) VALUES ('SI-2B');

-- Criando disciplinas
INSERT INTO disciplina (nome) VALUES ('Programação Web');
INSERT INTO disciplina (nome) VALUES ('Banco de Dados');

-- Vinculando tudo em Horários
-- O Professor João (1) vai dar Programação (1) para a turma SI-1A (1)
INSERT INTO horario (dia_semana, hora_inicio, hora_fim, professor_id, disciplina_id, turma_id) 
VALUES ('Segunda-feira', '08:00', '10:00', 1, 1, 1);

-- A Professora Maria (2) vai dar Banco de Dados (2) para a turma SI-2B (2)
INSERT INTO horario (dia_semana, hora_inicio, hora_fim, professor_id, disciplina_id, turma_id) 
VALUES ('Quarta-feira', '10:00', '12:00', 2, 2, 2);