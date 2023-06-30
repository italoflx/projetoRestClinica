package vitalabs.com.clinica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Consulta{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    Date dataHoraConsulta;
    String data;
    String hora;
    String queixas;
    String diagnosticos;
    String procedimentos;
    String prescricoes;
    String observacoes;

    public void setDataHoraConsulta(Date dataHoraConsulta){
        this.dataHoraConsulta = dataHoraConsulta;
        this.data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraConsulta);
        this.hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraConsulta);
    }

    public String getDataHoraConsulta(){
        return data+ " || " +hora;
    }
}
