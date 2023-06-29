package vitalabs.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vitalabs.com.clinica.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, String> {
}
