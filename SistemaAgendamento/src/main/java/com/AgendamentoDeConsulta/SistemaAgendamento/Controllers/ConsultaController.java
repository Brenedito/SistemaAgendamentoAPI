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
    UsersRepository usersRepository;

    @Autowired
    private ConsultasService Consulta;

    @GetMapping
    public List<Consultas> ListarConsultas(){
        Users User1 = new Users();
        Users User2 = new Users();

        User1.setNome("Breno");
        User1.setCpf("17891774017");
        User1.setEmail("adjdakjd@dajkodn.com");
        User1.setTipoUsuario("Paciente");
        usersRepository.save(User1);
        User2.setNome("Felipe");
        User2.setCpf("17891774017");
        User2.setEmail("adjdakjd@dajkodn.com");
        User2.setTipoUsuario("Médico");
        User2.setEspecialidade("Oftamologista");
        User2.setStatus(UserEnum.Disponivel);
        usersRepository.save(User2);
        return Consulta.ListarTodasAsConsultas();
    }

    @PostMapping
    public void AgendarConsulta(@RequestBody ConsultasDTO ConsultaDTO){
        System.out.println("Entrando no POST");
        Consulta.AgendarConsulta(ConsultaDTO);
    }

}
