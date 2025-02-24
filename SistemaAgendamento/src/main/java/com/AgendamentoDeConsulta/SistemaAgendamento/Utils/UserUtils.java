package com.AgendamentoDeConsulta.SistemaAgendamento.Utils;

import com.AgendamentoDeConsulta.SistemaAgendamento.Repositories.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    @Autowired
    UsersRepository usersRepository;

    public boolean VerificarExistenciaDoUsuario(long userid){
        if(usersRepository.findById(userid).isEmpty()){
            throw new EntityNotFoundException();
        }
        return true;
    }
}
