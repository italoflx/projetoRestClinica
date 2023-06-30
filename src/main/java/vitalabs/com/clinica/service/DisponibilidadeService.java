package vitalabs.com.clinica.service;

import org.springframework.stereotype.Service;
import vitalabs.com.clinica.repository.DisponibilidadeRepository;
import vitalabs.com.clinica.repository.ProntuarioRepository;

@Service
public class DisponibilidadeService{

    DisponibilidadeRepository repository;
    public DisponibilidadeService(DisponibilidadeRepository repository){
        this.repository = repository;
    }
}
