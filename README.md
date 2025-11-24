🍔 Hamburgueria BDD – Peppa Lanches

Projeto de testes BDD utilizando Java, Cucumber e JUnit Platform, desenvolvido para validar regras de negócio da Hamburgueria Peppa Lanches.

📌 Tecnologias

Java 21

Maven

Cucumber JVM

JUnit Platform

🧪 O que foi implementado

Cenários em Gherkin (pedidos.feature)

Steps em PT-BR com regras de negócio

Runner configurado para execução no Cucumber

Serviços para cálculo de pedidos e cardápio

📂 Estrutura do Projeto
src/
 ├─ main/java/peppa/hamburgueria/
 │    ├─ CardapioService.java
 │    └─ PedidoService.java
 └─ test/
      ├─ java/
      │    ├─ runner/RunnerTest.java
      │    └─ steps/PedidoSteps.java
      └─ resources/features/pedidos.feature

▶️ Como executar

No terminal, dentro do projeto:

mvn test

👤 Autor

Projeto desenvolvido como entrega da atividade de BDD.
