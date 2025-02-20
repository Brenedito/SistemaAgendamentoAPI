package com.AgendamentoDeConsulta.SistemaAgendamento.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @JoinColumn
    private String Cpf;
    @JoinColumn
    private String email;
    private String tipoUsuario;
    private String Especialidade = null;
    private enum Status{};
}
