# Event oriented architecture (Spring Boot, REST, Kafka, Java) project

This project is an implementation of an event oriented architecture.

## Docker

Create a directory to store the docker-compose.yml file.
Create and open docker-compose.yml.
Open https://hub.docker.com/r/bitnami/kafka to get the latest version.
Add the following lines (copied from the latest version):
```yaml
version: "3"
services:
  kafka:
    image: 'bitnami/kafka:latest'
    ports:
      - '9092:9092'
    environment:
      - KAFKA_CFG_NODE_ID=0
      - KAFKA_CFG_PROCESS_ROLES=controller,broker
      - KAFKA_CFG_LISTENERS=PLAINTEXT://:9092,CONTROLLER://:9093
      - KAFKA_CFG_LISTENER_SECURITY_PROTOCOL_MAP=CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT
      - KAFKA_CFG_CONTROLLER_QUORUM_VOTERS=0@kafka:9093
      - KAFKA_CFG_CONTROLLER_LISTENER_NAMES=CONTROLLER
```

If it doesn't work, try to use the version with zookeeper.

## Spring Boot

See pom.xml or https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.4&packaging=jar&jvmVersion=21&groupId=cc.tkmr&artifactId=event-oriented-architecture-springboot-rest-kafka-java&name=event-oriented-architecture-springboot-rest-kafka-java&description=Event%20oriented%20architecture%20using%20Spring%20Boot%2C%20Kafka%20and%20Java&packageName=cc.tkmr.event-oriented-architecture-springboot-rest-kafka-java&dependencies=web,kafka,lombok

Setup serialization in /resources/application.properties.

Create a new package called controller inside /java/<project>/.
Then create a new class OrdersController.java inside /java/<project>/controller/.
Controller package is where you put your REST API endpoints.

Create a new package called service inside /java/<project>/.
Then create a new class RegisterEventService.java inside /java/<project>/service/.

Create a new package called data inside /java/<project>/.
Then create a new class OrderData.java inside /java/<project>/data/.
It will be used to store data in Kafka.

### Testing

Run the application.
Run the Kafka Docker container. Enter the directory where docker-compose.yml was created and run using the following command:

```bash
docker-compose up -d
```

Open Postman and send a POST request to http://127.0.0.1:8080/api/save-order.
It should return 400 bad request because no parameters were sent.

Send:

```json
{
  "id": 1,
  "productName": "Car",
  "price": 1000.00
}
```

Should return 200 OK. Order saved.

