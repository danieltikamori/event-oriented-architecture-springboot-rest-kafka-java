package cc.tkmr.eventorientedarchitecturespringbootrestkafkajava.controller;

import cc.tkmr.eventorientedarchitecturespringbootrestkafkajava.data.OrderData;
import cc.tkmr.eventorientedarchitecturespringbootrestkafkajava.service.RegisterEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// REST controller
@RestController
@RequiredArgsConstructor // Lombok. Injects service.
public class OrdersController {

    private final RegisterEventService eventService;

    @PostMapping(path = "/api/save-order")
    public ResponseEntity<String> saveOrder(@RequestBody OrderData order) {
        eventService.addEvent("SaveOrder", order);
        return ResponseEntity.ok("Order saved");
    }
}
