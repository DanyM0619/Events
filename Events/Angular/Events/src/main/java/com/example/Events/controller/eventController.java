package com.example.Events.controller;


import com.example.Events.model.Event;
import com.example.Events.service.eventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class eventController {

    @Autowired
    private eventService service;

    @GetMapping
    public List<Event> viewAuto() {

        return this.service.viewAuto();
    }

    @PostMapping(path="/crear")
    public ResponseEntity<Object> addCar(@RequestBody Event car){
        Optional<Object> addCar = Optional.ofNullable(service.addCar(car));
        if (addCar.isPresent()) {
            return new ResponseEntity<>("Se creo el Auto", HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("No se creo el auto",HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping(path = "/update/{Id}")
    public ResponseEntity<Object> Update(@PathVariable Long Id, @RequestBody Event autoRegistration) {
        return this.service.updateAuto(Id, autoRegistration);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {

        return this.service.delete(id);
    }
}
