package vitalabs.com.clinica.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Paciente extends AbstractEntity{
    @OneToOne
    Prontuario prontuario;
    String cpf;
    Character sexo;
    String nome;
    String idade;
    Float altura;
    Float peso;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_paciente")
    List<Consulta> consultas;
}
