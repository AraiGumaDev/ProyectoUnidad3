package com.mateo_luis.service;

public interface ConsumptionRegisterService {

    void intercambio();
    void mediaDeConsumoPorVivienda();
    void mediaDeConsumoPorHabitante(Double totalDeAguaConsumida);
    void mediaDeHabitantesPorVivienda(Integer totalHabitantes);
    void medianaDeHabitantes();
    void modaDeHabitantesPorHogar();
    void registrosDesactualizados();
}
