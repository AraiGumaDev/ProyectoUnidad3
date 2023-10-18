package com.mateo_luis.service;

import org.junit.jupiter.api.Test;
import com.mateo_luis.repository.RegisterInMemoryRepositoryImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;

public class ConsumptionRegisterServiceImplTest {

    private ConsumptionRegisterService consuptioConsumptionRegisterService;

    @BeforeEach
    void setUp() {
        this.consuptioConsumptionRegisterService = new ConsumptionRegisterServiceImpl(new RegisterInMemoryRepositoryImpl());
      }

    @Test
    void media_de_consumo_de_agua_por_vivienda() {
        Double consumoPorVivienda = this.consuptioConsumptionRegisterService.mediaDeConsumoPorVivienda();

        assertEquals(consumoPorVivienda, 21910.25 );
    }

    @Test
    void total_agua_consumida() {
        Double totalAgua = this.consuptioConsumptionRegisterService.totalAguaConsumida();

        assertEquals(totalAgua, 438205.0 );
    }

    @Test
    void media_consumo_por_habitante() {
        Double totalAgua = this.consuptioConsumptionRegisterService.mediaDeConsumoPorHabitante(consuptioConsumptionRegisterService.totalAguaConsumida());
        assertEquals(totalAgua, 6086.18 );
    }
}
