 # Sistema de Gestao de Estacionamento.
O sistema de gestão de estacionamento é um projeto para gerenciar um estacionamento onde vai existir as funcionalidades de cadastrar mensalista, gerenciar tickets e gerenciar entrada e saída de veículos.

 ## Requisitos
 Certifique-se de ter as seguintes ferramentas instaladas:
 - Java Development Kit (JDK) 11 ou superior
 - Maven

 1. **Clone o repositório**
   ```bash
   git clone https://github.com/llLeinxx/Sistema-de-Gestao-de-Estacionamento.git
   cd Sistema-de-Gestao-de-Estacionamento
   ```
 2. **Compile o projeto**
   ```bash
   mvn clean install
   ```
 3. **Execute o projeto**
   Para executar o projeto, use o comando:
   ```bash
   mvn exec:java -Dexec.mainClass="application.Main"

 ### Estrutura do Projeto
 * `src/main/java`: Código-fonte principal do projeto
 * `src/test/java`: Testes automatizados
 * `pom.xml`: Arquivo de configuração do Maven
```

4. **Pensamentos sobre o projeto**
Devido a algumas dificuldades, a parte de inserção de vagas foi implementada para que o usuário digite o
número da vaga ao inserir o carro. Ainda há algumas melhorias a serem realizadas, como o funcionamento da lógica das
cancelas e a implementação de algumas validações que estão faltando, e funcionamento das vagas.
[sql_estacionamento.txt](https://github.com/user-attachments/files/16841049/sql_estacionamento.txt)
