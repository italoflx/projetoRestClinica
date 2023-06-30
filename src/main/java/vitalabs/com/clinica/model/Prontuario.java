package vitalabs.com.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String idPaciente;
    @CreationTimestamp
    LocalDateTime createdAt;
    String alergias;
    // Limitações: cognitivas, locomoção, visão, audição etc.
    String limitacoes;
}