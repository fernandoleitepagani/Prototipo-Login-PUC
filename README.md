# Protótipo Login PUC

> [!IMPORTANT] 
> Isso é um projeto pessoal educacional. Não é de maneira nenhuma afilidado oficialmente à instituição PUC Minas ou qualquer outra pessoa, basta-se apenas de um projeto relacionado à uma disciplina de Ciência da Computação.

## Sobre o projeto

O Projeto surge como parte de um projeto das aulas e oficinas de Desenvolvimento de Interface Web, com o objetivo de expandir conhecimento sobre as tecnologias e frameworks comumente usadas no mercado e seus usos e integrações. Tem-se como objetivo a expansão do projeto para, futuramente, expor também o conhecimento de backend, CI/CD e Docker.

## Tecnologias

- Frontend: html5, css, javascript
- Backend: ``virá posteriormente``
- Qualidade: ESLint, React Testing Library, JUnit 5 e MockMvc.

## Arquitetura

A aplicação LoginPUC é um monólito Spring Boot que entrega tanto a lógica de servidor quanto as páginas HTML ao navegador:

```text
Browser → Spring Boot (:8080) → Thymeleaf (templates) + recursos estáticos (CSS, fontes e imagens)
```

## Pré-requisitos

- Java 21+
- Git
- Maven
- Spring-boot


## Como executar

Rode ``mvn spring-boot:run`` no cerne do repositório e acesse no seu navegador padrão o ``localhost:8080/login``

## Estrutura do Repositório

.
├── imgs
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── src
