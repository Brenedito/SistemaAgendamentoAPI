package com.AgendamentoDeConsulta.SistemaAgendamento.dtos;

import java.time.LocalDate;

public record ConsultasDTO(long pacienteID, long medicoID, LocalDate DataConsulta) {
}
