package com.AgendamentoDeConsulta.SistemaAgendamento.Services;

import com.AgendamentoDeConsulta.SistemaAgendamento.Enums.UserEnum;
import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Consultas;
import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Users;
import com.AgendamentoDeConsulta.SistemaAgendamento.Repositories.ConsultasRepository;
import com.AgendamentoDeConsulta.SistemaAgendamento.Repositories.UsersRepository;
import com.AgendamentoDeConsulta.SistemaAgendamento.Utils.DataUtils;
import com.AgendamentoDeConsulta.SistemaAgendamento.dtos.ConsultasDTO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultasService  {
    
    @Autowired
    private DataUtils dataUtil;
    
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ConsultasRepository consultasRepository;


    public List<Consultas> ListarTodasAsConsultas() {
        return consultasRepository.findAll();
    }

    public Consultas AgendarConsulta(ConsultasDTO Consulta){
        Users Medico = usersRepository.getReferenceById(Consulta.medicoID());
        if(dataUtil.DataPassada(Consulta.DataConsulta())){
            return null; //Adicionar Exception.
        }
        if(!Medico.getTipoUsuario().equals("Médico") || Medico.getStatus().equals(UserEnum.Ocupado)){
            return null; //Adicionar Exception.
        }

        Consultas newConsulta = new Consultas(Consulta.pacienteID(),Consulta.medicoID(),Consulta.DataConsulta());
        Medico.setStatus(UserEnum.Ocupado);
        return consultasRepository.save(newConsulta);
    }
}
