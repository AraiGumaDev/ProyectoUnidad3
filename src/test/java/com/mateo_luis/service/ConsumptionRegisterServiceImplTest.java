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
        this.consuptioConsumptionRegisterService.ordenamientoBurbuja();
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
        Double mediaConsumo = this.consuptioConsumptionRegisterService.mediaDeConsumoPorHabitante(consuptioConsumptionRegisterService.totalAguaConsumida());
        assertEquals(mediaConsumo, 6086.18 );
    }

    @Test
    void total_de_habitantes() {
        Integer totalHabitantes = this.consuptioConsumptionRegisterService.totalHabitantes();
        assertEquals(totalHabitantes, 72 );
    }

    @Test
    void media_habitantes_por_vivienda() {
        Double mediaHabitantesVivienda = this.consuptioConsumptionRegisterService.mediaDeHabitantesPorVivienda(consuptioConsumptionRegisterService.totalHabitantes());
        assertEquals(mediaHabitantesVivienda, 3.6);
    }    

    @Test
    void mediana_de_habitantes() {
        Double medianaHabitantesVivienda = this.consuptioConsumptionRegisterService.medianaDeHabitantes();
        assertEquals(medianaHabitantesVivienda, 4.0);
    }    

   @Test
    void moda_habitantes_por_hogar() {
        Integer modaHabitantesPorHogar = this.consuptioConsumptionRegisterService.modaDeHabitantesPorHogar();
        assertEquals(modaHabitantesPorHogar, 4);
    }

    @Test
    void numero_de_registros_desactualizados() {
        Integer numRegistrosDesactualizados = this.consuptioConsumptionRegisterService.registrosDesactualizados();
        assertEquals(numRegistrosDesactualizados, 2);
    }
}
