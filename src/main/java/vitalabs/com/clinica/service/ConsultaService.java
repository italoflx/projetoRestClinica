package vitalabs.com.clinica.service;

import org.springframework.stereotype.Service;
import vitalabs.com.clinica.model.Consulta;
import vitalabs.com.clinica.repository.ConsultaRepository;

@Service
public class ConsultaService extends GenericService<Consulta, ConsultaRepository>{
    ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository){
        super(repository);
    }
}
