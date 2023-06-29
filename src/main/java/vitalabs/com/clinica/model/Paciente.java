package vitalabs.com.clinica.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "paciente")
public class Paciente extends AbstractEntity{
    @OneToOne
    @JoinColumn(name = "id_prontuario")
    Prontuario prontuario;
    String cpf;
    String alergias;
    Character sexo;
    String nome;
    String idade;
    Float altura;
    Float peso;
}
