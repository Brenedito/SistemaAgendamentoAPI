package com.AgendamentoDeConsulta.SistemaAgendamento.Repositories;

import com.AgendamentoDeConsulta.SistemaAgendamento.Models.Consultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultasRepository extends JpaRepository<Consultas, Long> {

}