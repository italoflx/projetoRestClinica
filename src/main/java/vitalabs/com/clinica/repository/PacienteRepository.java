package vitalabs.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitalabs.com.clinica.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, String> {

}
