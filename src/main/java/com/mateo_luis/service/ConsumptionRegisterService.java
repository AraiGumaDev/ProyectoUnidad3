package com.mateo_luis.service;

import com.mateo_luis.exception.RegisterNullPointerException;

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
}
