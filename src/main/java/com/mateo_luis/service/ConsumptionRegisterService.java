package com.mateo_luis.service;

public interface ConsumptionRegisterService {

    void ordenamientoBurbuja();
    void mediaDeConsumoPorVivienda();
    void mediaDeConsumoPorHabitante(Double totalDeAguaConsumida);
    void mediaDeHabitantesPorVivienda(Integer totalHabitantes);
    void medianaDeHabitantes();
    void modaDeHabitantesPorHogar();
    void registrosDesactualizados();
}
