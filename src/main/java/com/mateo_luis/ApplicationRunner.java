package com.mateo_luis;

import com.mateo_luis.exception.RegisterNullPointerException;
import com.mateo_luis.repository.RegisterUsingFileRepositoryImpl;
import com.mateo_luis.service.ConsumptionRegisterService;
import com.mateo_luis.service.ConsumptionRegisterServiceImpl;


public class ApplicationRunner {
    public static void main(String[] args) throws RegisterNullPointerException {
  
   ConsumptionRegisterService consumptionRegisterService = new ConsumptionRegisterServiceImpl(new RegisterUsingFileRepositoryImpl());
   consumptionRegisterService.ordenamientoBurbuja();
   consumptionRegisterService.mediaDeConsumoPorVivienda();
   consumptionRegisterService.mediaDeConsumoPorHabitante();
   consumptionRegisterService.mediaDeHabitantesPorVivienda();
   consumptionRegisterService.medianaDeHabitantes();
   consumptionRegisterService.modaDeHabitantesPorHogar();
   consumptionRegisterService.registrosDesactualizados();

  }
}
