package com.example.Events.service;

import com.example.Events.model.Event;
import com.example.Events.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class eventService {
    @Autowired
    private EventRepository eventRepository;

    //Metodo de ver
    public List<Event> viewAuto(){

        return this.eventRepository.findAll();
    }

    public ResponseEntity<Object> addCar(Event car) {
        Map<String, Object> message = new HashMap<>();

        // Verificar si el ID ya existe
        if (car.getId() != null && eventRepository.existsById(car.getId())) {
            message.put("message", "No se agregó el evento correctamente");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }

        // Asegurar que el ID sea nulo antes de persistir
        car.setId(null);

        Event guardarUser = eventRepository.save(car);
        message.put("message", "Se agregó el evento correctamente");

        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    // Método para actualizar un evento

    public ResponseEntity<Object> updateAuto(Long id, Event autoRegistration) {
        Map<String, Object> message = new HashMap<>();

        Optional<Event> existingAutoOptional = eventRepository.findById(id);

        if (existingAutoOptional.isPresent()) {
            Event existingAuto = existingAutoOptional.get();
            // Actualiza los valores del evento con los nuevos datos
            existingAuto.setTitle(autoRegistration.getTitle());
            existingAuto.setDateTime(autoRegistration.getDateTime());
            existingAuto.setDescription(autoRegistration.getDescription());
            existingAuto.setLocation(autoRegistration.getLocation());

            // Guardado automático con manejo de versiones por parte de Hibernate
            Event updatedAuto = eventRepository.save(existingAuto);
            message.put("message", "Se actualizó correctamente la base de Eventos");
            message.put("Datos", updatedAuto);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("error", true);
            message.put("Aviso", "No se encontró el evento deseado con el Id proporcionado");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    // Método para eliminar un evento
    public ResponseEntity<Object> delete(Long id) {
        boolean existing = this.eventRepository.existsById(id);
        Map<String, Object> message = new HashMap<>();
        if (!existing) {
            message.put("error", true);
            message.put("Aviso", "No existe el evento");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
        eventRepository.deleteById(id);
        message.put("Aviso", "Evento eliminado!");
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }
}
