package vitalabs.com.clinica.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Disponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    Date data;
    String hora;
    String local;
    String status;
}
