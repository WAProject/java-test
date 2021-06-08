# Teste Java

- Deverá ser criada uma api simples para cadastro de usuários.
- As tecnologias utilizadas foram: Java 11, Springboot 2.5, Mongodb e Apache Kafka.
- Foram utilizadas várias interfaces para auxiliar a implementação da API.


## Criação da API de cadastro de usuários

A Empresa XPTO deseja desenvolver um sistema de cadastramento de seus usuários, para isso você deve desenvolver a API de cadastro desses usuários.

Deverão ser criados 3 endpoints:
- **Listagem dos usuários cadastrados**: listagem com todos os usuários registrados até o momento;
- **Cadastro de um único usuário**: cadastro de um registro simples de usuários;
- **Cadastro de vários usuários**: Poderão ser enviados diversos usuários para cadastro de uma única vez, para isso foi acordado com a equipe de desenvolvimento que esses cadastros deverão ser processados assíncronamente. Esse endpoint deverá enviar uma mensagem para o Apache Kafka para ser processado em um processo serarado.


## Importante
Foram utilizadas as portas padrões dos servers: Mongodb e Apache Kafka.
Essas portas podem ser encontradas no arquivo _application.yml_
```yml
spring:
  data:
    mongodb:
      host: localhost
      port: 27017
      database: userDB
  kafka:
    url: localhost:9092
```

## Inicialização do projeto
Após ter realizado o download e a instalação.

[Zookepper](https://kafka.apache.org/downloads)
```bash
./bin/zookeeper-server-start.sh config/zookeeper.properties

```
[Apache Kafka](https://kafka.apache.org/downloads)
```bash
./bin/kafka-server-start.sh ./config/server.properties
```

[Mongodb](https://www.mongodb.com)
```bash
mongod
```