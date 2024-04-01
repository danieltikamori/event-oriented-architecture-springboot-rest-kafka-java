package cc.tkmr.eventorientedarchitecturespringbootrestkafkajava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class EventOrientedArchitectureSpringbootRestKafkaJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventOrientedArchitectureSpringbootRestKafkaJavaApplication.class, args);
	}

}
