package com.AgendamentoDeConsulta.SistemaAgendamento.Models;

import com.AgendamentoDeConsulta.SistemaAgendamento.Enums.UserEnum;
import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @JoinColumn
    private String cpf;
    @JoinColumn
    private String email;
    private String tipoUsuario;
    private String especialidade = null;
    private UserEnum status = UserEnum.Disponivel;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public UserEnum getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setStatus(UserEnum status) {
        this.status = status;
    }

    public Users(String nome, String cpf, String email, String tipoUsuario, String especialidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        if(tipoUsuario.equals("Médico") && especialidade == null){
            this.especialidade = "Geral";
        }else{
            this.especialidade = especialidade;
        }
    }

    public Users() {
    }
}
