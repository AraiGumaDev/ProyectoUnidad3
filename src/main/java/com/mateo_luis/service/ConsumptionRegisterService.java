package com.mateo_luis.service;

import com.mateo_luis.exception.RegisterNullPointerException;
import com.mateo_luis.model.Register;

import java.util.List;

public interface ConsumptionRegisterService {

    void ordenamientoBurbuja() throws RegisterNullPointerException;
    Double mediaDeConsumoPorVivienda();
    Double totalAguaConsumida();

    Double mediaDeConsumoPorHabitante();

    Integer totalHabitantes();

    Double mediaDeHabitantesPorVivienda();

    Double medianaDeHabitantes();
    Integer modaDeHabitantesPorHogar();
    Integer registrosDesactualizados();

    List<Register> listAllRegisters();

    Register addRegister(Register newRegister);
}
