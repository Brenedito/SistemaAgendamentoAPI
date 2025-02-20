package com.AgendamentoDeConsulta.SistemaAgendamento.Repositories;

import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Consultas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultasRepository extends JpaRepository<Consultas, Long> {
}
