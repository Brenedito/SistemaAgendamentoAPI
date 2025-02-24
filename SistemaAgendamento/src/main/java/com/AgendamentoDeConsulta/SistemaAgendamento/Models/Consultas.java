package com.AgendamentoDeConsulta.SistemaAgendamento.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


import java.time.LocalDate;

@Entity

public class Consultas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long pacienteID;
    private long medicoID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataConsulta;

    public long getPacienteID() {
        return pacienteID;
    }

    public void setPacienteID(long pacienteID) {
        this.pacienteID = pacienteID;
    }

    public LocalDate getdataConsulta() {
        return dataConsulta;
    }

    public void setdataConsulta(LocalDate dataConsulta) {
        dataConsulta = dataConsulta;
    }

    public long getMedicoID() {
        return medicoID;
    }

    public void setMedicoID(long medicoID) {
        this.medicoID = medicoID;
    }

    public Consultas(long pacienteID, long medicoID,LocalDate dataConsulta) {
        this.pacienteID = pacienteID;
        this.dataConsulta = dataConsulta;
        this.medicoID = medicoID;
    }

    public Consultas() {
    }
}
