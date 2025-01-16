# API de Eventos - Estudo com Spring WebFlux e SSE

Este projeto é um exemplo de como construir uma **API de Eventos** utilizando **Spring WebFlux** e **Server-Sent Events (SSE)**. O objetivo do projeto é demonstrar como criar uma API simples para gerenciar eventos e enviar atualizações em tempo real para os clientes usando SSE. O Spring WebFlux proporciona a base reativa para construção de APIs assíncronas e escaláveis.

## Tecnologias Utilizadas

- **Spring Boot**: Framework para construir APIs RESTful.
- **Spring WebFlux**: Para criação de APIs reativas e assíncronas.
- **Server-Sent Events (SSE)**: Para envio de atualizações em tempo real para o cliente.
- **MongoDB** (ou outro banco de dados reativo): Armazenamento de dados dos eventos.
- **Spring Data MongoDB Reactive**: Para interação reativa com o banco de dados.
- **Java 11+**: Linguagem utilizada para o desenvolvimento do projeto.

## Funcionalidades

A API permite gerenciar eventos e enviar atualizações em tempo real para os clientes. As funcionalidades incluem:

1. **Cadastrar Evento**: Permite criar um novo evento com nome e data.
2. **Listar Eventos**: Retorna uma lista de todos os eventos cadastrados.
3. **Atualizar Evento**: Permite a atualização de eventos já cadastrados.
4. **Excluir Evento**: Permite excluir um evento.
5. **Enviar Atualizações em Tempo Real**: Usando SSE para notificar os clientes sobre mudanças nos eventos (ex: atualizações de status ou novas informações).

## Como Rodar o Projeto

### Pré-requisitos

1. **Java 21 ou superior**: Certifique-se de ter o openJDK 21 ou superior instalado.
2. **PostgreSql**: Um banco de dados PostgreSql rodando localmente ou em um container Docker. Caso queira usar outro banco de dados, altere a configuração do Spring Data Reactive para o banco desejado.
3. **Maven** ou **Gradle**: Para compilar e rodar o projeto.

### Passos para Executar

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/api-eventos-spring-webflux.git
   cd api-eventos-spring-webflux

2. Inicie container ou base de dados com nome database

3. Suba aplicação para ocorrer as migration


### Dentro de 'Doc' temos a collection do serviço
Execute pelo postman ou ferramenta simular 
