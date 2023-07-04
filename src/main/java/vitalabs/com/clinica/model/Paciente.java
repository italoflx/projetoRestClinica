package vitalabs.com.clinica.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.br.CPF;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;
import vitalabs.com.clinica.controller.PacienteController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@SQLDelete(sql = "UPDATE pessoa SET deleted_at = CURRENT_TIMESTAMP WHERE id=?")
@Where(clause = "deleted_at is null")
public class Paciente extends AbstractEntity{
    @OneToOne
    Prontuario prontuario;
    String cpf;
    Character sexo;
    Integer idade;
    Float altura;
    Float peso;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_paciente")
    List<Consulta> consultas;

    @Data
    public static class DtoRequest{
        //Validacoes nao funcionam ainda
        String nome;
        @CPF
        @NotNull(message = "Usuário com CPF em branco")
        String cpf; //validar cpf
        Character sexo;
        @Min(value = 0, message = "Idade inválida")
        Integer idade;
        @Min(value = 0, message = "Altura inválida")
        Float altura;
        @Min(value = 0, message = "Peso inválido")
        Float Peso;


        public static Paciente convertToEntity(DtoRequest dto, ModelMapper mapper){
            return mapper.map(dto, Paciente.class);
        }
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class DtoResponse extends RepresentationModel<DtoResponse> {
        String cpf;
        Character sexo;
        String nome;
        String idade;
        Float altura;
        Float peso;

        public static Paciente.DtoResponse convertToDto(Paciente p, ModelMapper mapper){
            return mapper.map(p, Paciente.DtoResponse.class);
        }

        public void generateLinks(String id){
            add(linkTo(PacienteController.class).slash(id).withSelfRel());
            add(linkTo(PacienteController.class).withRel("pacientes"));
            add(linkTo(PacienteController.class).slash(id).withRel("delete"));
        }

    }
}
