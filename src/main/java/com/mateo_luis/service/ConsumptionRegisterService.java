package com.mateo_luis.service;

public interface ConsumptionRegisterService {

    void ordenamientoBurbuja();
    Double mediaDeConsumoPorVivienda();
    Double totalAguaConsumida();
    Double mediaDeConsumoPorHabitante(Double totalDeAguaConsumida);
    Integer totalHabitantes();
    void mediaDeHabitantesPorVivienda(Integer totalHabitantes);
    void medianaDeHabitantes();
    void modaDeHabitantesPorHogar();
    void registrosDesactualizados();
}
