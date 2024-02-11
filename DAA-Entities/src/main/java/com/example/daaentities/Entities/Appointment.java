package com.example.daaentities.Entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    //Constructor
    public Appointment() {
        //Default Constructor
    }

    //Convert Time --> Bangkok Time
    public Timestamp convertToBangkok (Timestamp timestamp) {
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        ZoneId currentZone = ZoneId.of("UTC");
        ZoneId bangkokZone = ZoneId.of("Asia/Bangkok");
        ZonedDateTime utcDateTime = ZonedDateTime.of(localDateTime, currentZone);
        ZonedDateTime bangkokDateTime = utcDateTime.withZoneSameInstant(bangkokZone);
        return Timestamp.valueOf(bangkokDateTime.toLocalDateTime());
    }

    //Getter & Setter
    public Integer getId() {
        return id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    // Setter
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}
