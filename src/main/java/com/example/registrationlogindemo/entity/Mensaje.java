package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Data
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name="emisor_id")
    private User emisor;
    @ManyToOne
    @JoinColumn(name="destinatario_id")
    private User destinatario;
    @Column(columnDefinition = "TEXT")
    private String contenido;
    @DateTimeFormat(pattern = "dd/MM/YYYY")
    private LocalDateTime fecha;

    public Mensaje(){
        fecha=LocalDateTime.now();
    }

    public Mensaje(User emisor, User destinatario, String contenido){
        this.fecha=LocalDateTime.now();
        this.emisor=emisor;
        this.destinatario=destinatario;
        this.contenido=contenido;
    }

    public void setFecha(LocalDateTime localDateTime) {
    }
}
