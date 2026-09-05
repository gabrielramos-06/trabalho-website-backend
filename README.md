# Projeto de Website - Back End

## Alunos
- Jonas Guilhermino Nascimento
- Gabriel Oliveira Ramos

## Sobre o Projeto
Sistema web desenvolvido para organizar e gerenciar horários de aulas, solucionando o desafio logístico de alocação acadêmica sem gerar conflitos. O projeto contempla as seguintes funcionalidades:
- Cadastro completo de dados (operações de criar, ler, atualizar e deletar).
- Visualização de grades de horários filtradas por professor.
- Visualização de grades de horários filtradas por turma.

## Tecnologias e Estruturas
O projeto foi construído baseando-se no padrão arquitetural MVC (Model-View-Controller) com forte separação de responsabilidades.
- Back-end: Linguagem Java, framework Spring Boot e Spring Data JPA.
- Front-end: HTML, CSS e o motor de templates Thymeleaf.
- Banco de Dados: H2 Database (configurado para rodar em memória).
- Entidades Mapeadas: Professores, Disciplinas, Turmas e Horários.

## Configurações do Banco de Dados
As variáveis de ambiente e configurações abaixo (presentes no application.properties) preparam o banco H2 e garantem a injeção de dados de teste de forma automática.
- `spring.application.name=demo`
- `spring.datasource.url=jdbc:h2:mem:testdb`
- `spring.datasource.driverClassName=org.h2.Driver`
- `spring.datasource.username=sa`
- `spring.datasource.password=`
- `spring.jpa.database-platform=org.hibernate.dialect.H2Dialect`
- `spring.h2.console.enabled=true`
- `spring.jpa.hibernate.ddl-auto=update`
- `spring.jpa.defer-datasource-initialization=true`

## Como Executar Localmente
Siga os passos abaixo para testar o sistema em sua máquina.
- `Clone este repositório para o seu computador.`
- `Abra a pasta do projeto em sua IDE de preferência`
- `Inicie o servidor local executando a classe principal DemoApplication.java`
- `Acesse o sistema abrindo o seu navegador no endereço http://localhost:8080`
- `/consultas/professor;/consultas/turma;/professores;/turmas;/disciplinas;/horarios`

## Funcionalidades implementadas
- Cadastro de dados;
- Visualização de horários por professor;
- Visualização de horários por turma;
