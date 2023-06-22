package vitalabs.com.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @OneToOne
    @JoinColumn(name = "id_prontuario")
    Prontuario prontuario;
    String cpf;
    String email;
    String alergias;
    Character sexo;
    String nome;
    String idade;
    Float altura;
    Float peso;
    String contato;
}
