package com.mateo_luis.service;

public interface ConsumptionRegisterService {

    void ordenamientoBurbuja();
    Double mediaDeConsumoPorVivienda();
    Double totalAguaConsumida();
    Double mediaDeConsumoPorHabitante(Double totalDeAguaConsumida);
    Integer totalHabitantes();
    Double mediaDeHabitantesPorVivienda(Integer totalHabitantes);
    Double medianaDeHabitantes();
    Integer modaDeHabitantesPorHogar();
    Integer registrosDesactualizados();
}
