package vitalabs.com.clinica.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vitalabs.com.clinica.model.Paciente;
import vitalabs.com.clinica.service.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    PacienteService service;
    ModelMapper mapper;

    public PacienteController(PacienteService service, ModelMapper mapper){
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<Paciente.DtoResponse> list(){
        return this.service.list().stream().map(
                elementoAtual -> {
                    Paciente.DtoResponse response = Paciente.DtoResponse.convertToDto(elementoAtual, mapper);
                    response.generateLinks(elementoAtual.getId());
                    return response;
                }).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente.DtoResponse create(@RequestBody Paciente.DtoRequest p){

        Paciente paciente = this.service.create(Paciente.DtoRequest.convertToEntity(p, mapper));

        Paciente.DtoResponse response = Paciente.DtoResponse.convertToDto(paciente, mapper);
        response.generateLinks(paciente.getId());

        return response;
    }

    @GetMapping("{id}")
    public Paciente.DtoResponse getById(@PathVariable String id){
        Paciente paciente = this.service.getById(id);
        Paciente.DtoResponse response = Paciente.DtoResponse.convertToDto(paciente, mapper);
        response.generateLinks(paciente.getId());

        return response;
    }

    @PutMapping("{id}")
    public Paciente update(@RequestBody Paciente p, @PathVariable String id){
        return this.service.update(p, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        this.service.delete(id);
    }
}