package com.mateo_luis.service;
import com.mateo_luis.model.Register;
import com.mateo_luis.repository.RegisterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConsumptionRegisterServiceImpl implements ConsumptionRegisterService {

    private static List<Register> registrosLista;
    private static final Logger logger = LoggerFactory.getLogger(ConsumptionRegisterServiceImpl.class);
    private final RegisterRepository registerRepository;

    public ConsumptionRegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

 /*
    RegisterUsingFileRepositoryImpl registro = new RegisterUsingFileRepositoryImpl();
    List<Register> registrosDeConsumoDeAgua = this.registerRepository.findAllRegisters();


   public ConsumptionRegisterServiceImpl(RegisterUsingFileRepositoryImpl registerUsingFileRepositoryImpl) {
    }
    */

    @Override
    public void ordenamientoBurbuja() {
        boolean ordenamientoBurbuja;
        registrosLista = this.registerRepository.findAllRegisters();
        for (int i = 0; i < registrosLista.size() - 1; i++) {
            ordenamientoBurbuja = false;

            for (int j = 0; j < registrosLista.size() - i - 1; j++) {
                if (registrosLista.get(j).numeroHabitantes() > registrosLista.get(j + 1).numeroHabitantes()) {
                    Register temp = registrosLista.get(j);
                    registrosLista.set(j, registrosLista.get(j + 1));
                    registrosLista.set(j + 1, temp);
                    ordenamientoBurbuja = true;
                }
            }
            if (!ordenamientoBurbuja) {
                break;
            }
        }
    }

    @Override
    public Double mediaDeConsumoPorVivienda() {
        System.out.println("----Media de consumo por vivienda----");
        Double aguaConsumidaTotal = totalAguaConsumida();
        Double promedioPorVivienda = aguaConsumidaTotal / registrosLista.size();
        System.out.println("\n En total las " + registrosLista.size() + " viviendas listadas consumieron: "
                + aguaConsumidaTotal + " Litros. Lo que da un promedio por vivienda de: " + promedioPorVivienda + " Litros");

        return promedioPorVivienda;
    }

    @Override
    public Double totalAguaConsumida(){
        Double aguaConsumidaTotal = 0D;
        for (Register registroConsumoAgua : registrosLista) {
            aguaConsumidaTotal = aguaConsumidaTotal + registroConsumoAgua.consumoAguaMes();
        }
    return aguaConsumidaTotal;
    }

    @Override
    public Double mediaDeConsumoPorHabitante() {
        System.out.println("\n----Media de consumo por habitante----");
        Integer numeroHabitantes = totalHabitantes();
        Double promedioPorHabitante = Math.round((totalAguaConsumida() / numeroHabitantes)*100.0)/100.0;
        System.out.println("\n Habiendo " + numeroHabitantes + " habitantes listados, el promedio de consumo por persona sería "
                + promedioPorHabitante + " Litros");
        return promedioPorHabitante;
    }

    @Override
    public Integer totalHabitantes(){
        Integer habitantesTotal=0;
        for (Register registroConsumoAgua : registrosLista) {
            habitantesTotal = habitantesTotal + registroConsumoAgua.numeroHabitantes();
        }
        return habitantesTotal;
    }

    @Override
    public Double mediaDeHabitantesPorVivienda() {
        System.out.println("\n----Media de habitantes por vivienda----");
        Double promediodeHabitantes = totalHabitantes() / (double) registrosLista.size();
        System.out.println("\n En la comunidad hay un promedio de " + promediodeHabitantes + " habitantes por vivienda");
        return promediodeHabitantes;
    }

    @Override
    public Double medianaDeHabitantes() {
        logger.info( "Calculando mediana de habitantes" );
        System.out.println("\n----Mediana de habitantes----");
        String medianaHabitantes = "";

        if (this.registrosLista.size() % 2 == 0) {
            int posicion1 = registrosLista.size() / 2 - 1;
            int posicion2 = registrosLista.size() / 2;
            medianaHabitantes = "" + (((registrosLista.get(posicion1).numeroHabitantes() * 1.0) +
                    registrosLista.get(posicion2).numeroHabitantes()) / 2);
        } else {
            int posicion = (registrosLista.size() - 1) / 2;
            medianaHabitantes = "" + registrosLista.get(posicion).numeroHabitantes();
        }
        System.out.println("\n La mediana de habitantes por hogar es: " + medianaHabitantes);
        return Double.parseDouble(medianaHabitantes);
        
    }

    @Override
    public Integer modaDeHabitantesPorHogar() {
        System.out.println("\n----La moda de habitantes por hogar----");
        int maximoNumRepeticiones = 0;
        List<Integer> moda = new ArrayList<>();

        for (int i = 0; i < registrosLista.size(); i++) {
            int contadorRepeticiones = 0;
            for (int j = 0; j < registrosLista.size(); j++) {
                if (Objects.equals(registrosLista.get(i).numeroHabitantes(), registrosLista.get(j).numeroHabitantes())) {
                    contadorRepeticiones++;
                }
            }
            if (contadorRepeticiones > maximoNumRepeticiones) {
                moda.clear();
                moda.add(registrosLista.get(i).numeroHabitantes());
                maximoNumRepeticiones = contadorRepeticiones;
            } else if (contadorRepeticiones == maximoNumRepeticiones && !moda.contains(registrosLista.get(i).numeroHabitantes())) {
                moda.add(registrosLista.get(i).numeroHabitantes());
            }
        }

        System.out.println("\n La moda de habitantes por hogar es: ");
        for (int i = 0; i < moda.size(); i++) {
            System.out.print(moda.get(i));
            if (i < moda.size() - 2) {
                System.out.print(" ");
            } else if (i == moda.size() - 2) {
                System.out.print(" y ");
            }
        }
        System.out.println(" que se repitieron " + maximoNumRepeticiones + " veces.");
        return moda.get(moda.size()-1);
    }

    @Override
    public Integer registrosDesactualizados() {
        System.out.println("\n----Registros desactualizados----");
        System.out.println("\n Las siguientes viviendas tienen registros anteriores a el 2023-08-14:");
        Integer count = 0;
        for (Register registroConsumoAgua : registrosLista){
            if (registroConsumoAgua.fechaUltimaMedicion().isBefore(LocalDate.parse("14/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")))) {
                System.out.println(registroConsumoAgua.direccion()+"\túltimo registro: "+registroConsumoAgua.fechaUltimaMedicion());
                count++;
            }
        }
        return count;
    }


}

