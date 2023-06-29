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
@Table(name = "prontuario")
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_prontuario")
    String id;
    String idPaciente;
    @CreationTimestamp
    LocalDateTime createdAt;
    String alergias;
    // Limitações: cognitivas, locomoção, visão, audição etc.
    String limitacoes;
}