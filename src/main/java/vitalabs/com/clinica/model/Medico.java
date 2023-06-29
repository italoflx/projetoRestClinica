package vitalabs.com.clinica.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Medico{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_medico")
    String id;
    String nome;
    String contato;
    String email;
    LocalDateTime deletedAt;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
    String crm;
    String especialidade;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "medico_disponibilidade", joinColumns = { @JoinColumn(name =
            "medico_id", referencedColumnName = "id_medico") }, inverseJoinColumns = {
            @JoinColumn(name = "disponibilidade_id") })
    List<Disponibilidade> disponibilidades = new ArrayList<Disponibilidade>();

}
