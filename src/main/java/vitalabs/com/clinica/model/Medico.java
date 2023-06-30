package vitalabs.com.clinica.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Medico extends AbstractEntity{
    String crm;
    String especialidade;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="id_medico")
    List<Consulta> consultas = new ArrayList<Consulta>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "medico_disponibilidade", joinColumns = { @JoinColumn(name =
            "medico_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "disponibilidade_id") })
    List<Disponibilidade> disponibilidades = new ArrayList<Disponibilidade>();
}
