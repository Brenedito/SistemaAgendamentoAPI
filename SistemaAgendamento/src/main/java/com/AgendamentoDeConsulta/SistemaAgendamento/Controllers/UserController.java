package com.AgendamentoDeConsulta.SistemaAgendamento.Controllers;


import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Users;
import com.AgendamentoDeConsulta.SistemaAgendamento.Services.UsersService;
import com.AgendamentoDeConsulta.SistemaAgendamento.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsersService usersRepository;

    @GetMapping
    public List<Users> listarUsarios(){
        return usersRepository.listarUsuarios();
    }

    @PostMapping
    public Users criarUsuario(@RequestBody UserDTO userDTO){
        return usersRepository.criarUsuario(userDTO);
    }


}
