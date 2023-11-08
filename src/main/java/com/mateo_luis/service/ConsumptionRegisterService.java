package com.mateo_luis.service;

public interface ConsumptionRegisterService {

    void ordenamientoBurbuja();
    Double mediaDeConsumoPorVivienda();
    Double totalAguaConsumida();

    Double mediaDeConsumoPorHabitante();

    Integer totalHabitantes();

    Double mediaDeHabitantesPorVivienda();

    Double medianaDeHabitantes();
    Integer modaDeHabitantesPorHogar();
    Integer registrosDesactualizados();
}
