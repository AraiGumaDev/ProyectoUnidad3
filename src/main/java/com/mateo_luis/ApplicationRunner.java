package com.mateo_luis;

import com.mateo_luis.repository.RegisterInMemoryRepositoryImpl;
import com.mateo_luis.service.ConsumptionRegisterService;
import com.mateo_luis.service.ConsumptionRegisterServiceImpl;

public class ApplicationRunner {
    public static void main(String[] args) {
  
   ConsumptionRegisterService consumptionRegisterService = new ConsumptionRegisterServiceImpl(new RegisterInMemoryRepositoryImpl());
      
   consumptionRegisterService.ordenamientoBurbuja();
   consumptionRegisterService.mediaDeConsumoPorVivienda();
   //consumptionRegisterService.mediaDeConsumoPorHabitante(Double totalDeAguaConsumida);
   //consumptionRegisterService.mediaDeHabitantesPorVivienda(Integer totalHabitantes);
   consumptionRegisterService.medianaDeHabitantes();
   consumptionRegisterService.modaDeHabitantesPorHogar();
   consumptionRegisterService.registrosDesactualizados();

  }
}
