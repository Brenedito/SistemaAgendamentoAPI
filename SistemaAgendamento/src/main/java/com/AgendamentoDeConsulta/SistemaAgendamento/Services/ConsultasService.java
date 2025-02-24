package com.AgendamentoDeConsulta.SistemaAgendamento.Services;

import com.AgendamentoDeConsulta.SistemaAgendamento.Enums.UserEnum;
import com.AgendamentoDeConsulta.SistemaAgendamento.Expetion.DataException;
import com.AgendamentoDeConsulta.SistemaAgendamento.Expetion.StatusException;
import com.AgendamentoDeConsulta.SistemaAgendamento.Expetion.UserTypeException;
import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Consultas;
import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Users;
import com.AgendamentoDeConsulta.SistemaAgendamento.Repositories.ConsultasRepository;
import com.AgendamentoDeConsulta.SistemaAgendamento.Repositories.UsersRepository;
import com.AgendamentoDeConsulta.SistemaAgendamento.Utils.DataUtils;
import com.AgendamentoDeConsulta.SistemaAgendamento.Utils.UserUtils;
import com.AgendamentoDeConsulta.SistemaAgendamento.dtos.ConsultasDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultasService  {
    
    @Autowired
    private DataUtils dataUtil;

    @Autowired
    private UserUtils userUtil;
    
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ConsultasRepository consultasRepository;




    public List<Consultas> ListarTodasAsConsultas() {
        return consultasRepository.findAll();
    }

    public void AgendarConsulta(ConsultasDTO Consulta){
        try {
            userUtil.VerificarExistenciaDoUsuario(Consulta.pacienteID());
        } catch (EntityNotFoundException e){
            System.out.println("Usuario não existe");
            throw new EntityNotFoundException();
        }
        Users Medico = usersRepository.getReferenceById(Consulta.medicoID());

        if(dataUtil.DataPassada(Consulta.DataConsulta())){
            throw new DataException("Data anterior a atual"); //Adicionar Exception.
        }
        if(!Medico.getTipoUsuario().equals("Médico")){
            throw new UserTypeException("O Usuario não é médico"); //Adicionar Exception.
        }
        if(Medico.getStatus().equals(UserEnum.Ocupado)){
            throw new StatusException("Médico Ocupado");
        }

        Consultas newConsulta = new Consultas(Consulta.pacienteID(),Consulta.medicoID(),Consulta.DataConsulta());
        Medico.setStatus(UserEnum.Ocupado);
        consultasRepository.save(newConsulta);
    }
}
