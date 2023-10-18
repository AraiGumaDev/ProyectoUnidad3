package com.mateo_luis.service;

import org.junit.jupiter.api.Test;
import com.mateo_luis.repository.RegisterInMemoryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;

public class ConsumptionRegisterServiceImplTest {

    private ConsumptionRegisterService consuptioConsumptionRegisterService;

    @BeforeEach
    void setUp() {
        this.consuptioConsumptionRegisterService = new ConsumptionRegisterServiceImpl(new RegisterInMemoryRepositoryImpl());
      }

    @Test
    void cuando_media_de_consumo_de_agua_por_vivienda_es_cero() {
        
    
    }
}
