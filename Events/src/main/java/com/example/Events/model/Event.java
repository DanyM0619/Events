package com.example.Events.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Id")
    private Long Id;
    @Version
    private Integer version;
    @Column(name ="Titulo")
    private String title;
    @Column(name ="Hora y Fecha")
    private LocalDateTime dateTime;
    @Column(name ="Descripcion")
    private String description;
    @Column(name ="Ubicacion")
    private String location;

    // Getters and Setters
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Event(Long Id, String title, LocalDateTime dateTime, String description, String location){
        Id = Id;
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
        this.location = location;
    }

    public Event(String title, LocalDateTime dateTime, String description, String location){
        this.title = title;
        this.dateTime = dateTime;
        this.description = description;
        this.location = location;
    }

    public Event(){
        this.version = 0;
    }
}
