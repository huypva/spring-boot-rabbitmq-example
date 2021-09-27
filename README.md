The example project for StringBoot service

<div align="center">
    <img src="./assets/images/spring_boot_icon.png"/>
</div>

## Getting Started

## Project structure
```
.
├── spring-boot-rabbitmq
│   ├── Dockerfile
│   ...
├── docker-compose.yaml
|
└── README.md
```

## Prerequisites
- Make sure that you have Docker and Docker Compose installed
  - Windows or macOS:
    [Install Docker Desktop](https://www.docker.com/get-started)
  - Linux: [Install Docker](https://www.docker.com/get-started) and then
    [Docker Compose](https://github.com/docker/compose)

## Start project
### Start infrastructure

```shell script
$ docker-compose -f ./docker-compose-infrastructure.yml -p spring-boot-rabbit-infrastructure up -d
```

### Start project in local

- Build project
```shell script
$ ./mvnw clean package
$ cd spring-boot-rabbitmq
$ ../mvnw spring-boot:run
...
```

### Start project in docker 

- Start project
```shell script
$ docker-compose -f ./docker-compose-service.yml -p spring-boot-rabbit-service up -d
```

- Stop project
```shell script
docker-compose down
```

## Run testing

```shell script
$ curl http://localhost:8081/greet?name=World
2021-09-27 10:33:53.039  INFO 1765 --- [ntContainer#0-1] i.c.s.e.rabbitmq.GreetingRabbitListener  : Listen message from Rabbit: {"id":0,"message":"Hello World!"}
2021-09-27 10:33:53.044  INFO 1765 --- [ntContainer#0-1] i.c.s.e.rabbitmq.GreetingRabbitListener  : Message id=0, message=Hello World!
```

## Contribute

## Reference

- https://spring.io/guides/gs/messaging-rabbitmq/
- https://www.baeldung.com/spring-amqp
- https://www.javainuse.com/spring/spring-boot-rabbitmq-hello-world
- https://jstobigdata.com/rabbitmq/rabbitmq-with-spring-amqp-and-spring-boot/
- https://kipalog.com/posts/RabbitMQ-Topic-Exchange-Spring-Boot-Example