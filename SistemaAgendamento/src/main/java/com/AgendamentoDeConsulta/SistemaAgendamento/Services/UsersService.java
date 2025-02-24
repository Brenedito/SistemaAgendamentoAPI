package com.AgendamentoDeConsulta.SistemaAgendamento.Services;

import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Users;
import com.AgendamentoDeConsulta.SistemaAgendamento.Repositories.UsersRepository;
import com.AgendamentoDeConsulta.SistemaAgendamento.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> listarUsuarios() {
        return usersRepository.findAll();
    }

    public Users criarUsuario(UserDTO userDTO) {
        Users newUser = new Users(userDTO.nome(),userDTO.cpf(),userDTO.email(),userDTO.tipoUsuario(),userDTO.especialidade());
        return usersRepository.save(newUser);
    }
}
