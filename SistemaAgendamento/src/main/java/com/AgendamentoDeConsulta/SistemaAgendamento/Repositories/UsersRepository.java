package com.AgendamentoDeConsulta.SistemaAgendamento.Repositories;

import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
