package com.AgendamentoDeConsulta.SistemaAgendamento.Utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataUtils {

    public boolean DataPassada(LocalDate Data){
        return LocalDate.now().isAfter(Data);
    }
}
