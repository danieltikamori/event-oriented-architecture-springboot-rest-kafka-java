package cc.tkmr.eventorientedarchitecturespringbootrestkafkajava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// Injects service.
@Service
// Lombok. Injects constructor, eliminates the need for creating contructors.
@RequiredArgsConstructor
public class RegisterEventService {

    private final KafkaTemplate<Object, Object> kafkaTemplate; // <key, value> type

    public <T> void addEvent(String topic, T data) { // T is a generic type. Topic name and the data to be added.
        kafkaTemplate.send(topic, data);

    }


}
