package vitalabs.com.clinica.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Disponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "disponibilidade_id")
    String id;
    Date data;
    String hora;
    String local;
    String status;
}
