package com.AgendamentoDeConsulta.SistemaAgendamento.Controllers;

import com.AgendamentoDeConsulta.SistemaAgendamento.Enums.UserEnum;
import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Consultas;
import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Users;
import com.AgendamentoDeConsulta.SistemaAgendamento.Repositories.UsersRepository;
import com.AgendamentoDeConsulta.SistemaAgendamento.Services.ConsultasService;
import com.AgendamentoDeConsulta.SistemaAgendamento.dtos.ConsultasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(("/consulta"))
public class ConsultaController {

    @Autowired
    private ConsultasService Consulta;

    @GetMapping
    public List<Consultas> ListarConsultas(){
        return Consulta.ListarTodasAsConsultas();
    }

    @PostMapping
    public void AgendarConsulta(@RequestBody ConsultasDTO ConsultaDTO){
        Consulta.AgendarConsulta(ConsultaDTO);
    }

}
