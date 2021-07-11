# Spring Boot and RabbitMQ Example

Simple application with Spring Boot and RabbitMQ
<br/>
<br/> 


* Orders are adding to the queue.
* Thread.sleep() is being called to simulating some operations.
* Order taking from the queue and after that saving to database.


<br/>
<br/> 



Run RabbitMQ on Docker

```shell
docker run -d -p 5672:5672 -p 15672:15672 --hostname my-rabbit --name my-rabbit rabbitmq:latest
``` 

<br/> 

Run Spring Boot Application

```shell
mvn spring-boot:run
``` 

<br/> 

### Swagger UI
Swagger UI: http://localhost:8080/swagger-ui.html

<br/> 

### H2 Console
Swagger UI: http://localhost:8080/h2-console
