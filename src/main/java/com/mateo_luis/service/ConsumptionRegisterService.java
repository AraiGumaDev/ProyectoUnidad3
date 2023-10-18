package com.mateo_luis.service;

public interface ConsumptionRegisterService {

    void ordenamientoBurbuja();
    void mediaDeConsumoPorVivienda();
    Double totalAguaConsumida();
    void mediaDeConsumoPorHabitante(Double totalDeAguaConsumida);
    Integer totalHabitantes();
    void mediaDeHabitantesPorVivienda(Integer totalHabitantes);
    void medianaDeHabitantes();
    void modaDeHabitantesPorHogar();
    void registrosDesactualizados();
}
