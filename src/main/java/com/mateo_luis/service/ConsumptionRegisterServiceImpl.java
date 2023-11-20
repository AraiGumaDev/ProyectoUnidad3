package com.mateo_luis.service;
import com.mateo_luis.exception.RegisterNullPointerException;
import com.mateo_luis.model.Register;
import com.mateo_luis.repository.RegisterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConsumptionRegisterServiceImpl implements ConsumptionRegisterService {


    private static final Logger logger = LoggerFactory.getLogger(ConsumptionRegisterServiceImpl.class);
    private final RegisterRepository registerRepository;

    public ConsumptionRegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }


    @Override
    public void ordenamientoBurbuja() throws RegisterNullPointerException {
        logger.info("Aplicando ordenamiento");
        boolean ordenamientoBurbuja;
        if (this.registerRepository.findAllRegisters().isEmpty()) {
            logger.error( "La lista está vacía {}", this.registerRepository.findAllRegisters() );
            throw new RegisterNullPointerException(this.registerRepository.findAllRegisters());
        } else {
            for (int i = 0; i < this.registerRepository.findAllRegisters().size() - 1; i++) {
                ordenamientoBurbuja = false;

                for (int j = 0; j < this.registerRepository.findAllRegisters().size() - i - 1; j++) {
                    if (this.registerRepository.findAllRegisters().get(j).numeroHabitantes() > this.registerRepository.findAllRegisters().get(j + 1).numeroHabitantes()) {
                        Register temp = this.registerRepository.findAllRegisters().get(j);
                        this.registerRepository.findAllRegisters().set(j, this.registerRepository.findAllRegisters().get(j + 1));
                        this.registerRepository.findAllRegisters().set(j + 1, temp);
                        ordenamientoBurbuja = true;
                    }
                }
                if (!ordenamientoBurbuja) {
                    break;
                }
            }
        }
    }

    @Override
    public Double mediaDeConsumoPorVivienda() {
        logger.info("Calculando media de consumo por vivienda");
        System.out.println("----Media de consumo por vivienda----");
        Double aguaConsumidaTotal = totalAguaConsumida();
        Double promedioPorVivienda = aguaConsumidaTotal / this.registerRepository.findAllRegisters().size();
        System.out.println("\n En total las " + this.registerRepository.findAllRegisters().size() + " viviendas listadas consumieron: "
                + aguaConsumidaTotal + " Litros. Lo que da un promedio por vivienda de: " + promedioPorVivienda + " Litros");

        return promedioPorVivienda;
    }

    @Override
    public Double totalAguaConsumida(){
        logger.info("Calculando total Agua consumida");
        Double aguaConsumidaTotal = 0D;
        for (Register registroConsumoAgua : this.registerRepository.findAllRegisters()) {
            aguaConsumidaTotal = aguaConsumidaTotal + registroConsumoAgua.consumoAguaMes();
        }
    return aguaConsumidaTotal;
    }

    @Override
    public Double mediaDeConsumoPorHabitante() {
        logger.info("Calculando media de consumo por habitante");
        System.out.println("\n----Media de consumo por habitante----");
        Integer numeroHabitantes = totalHabitantes();
        Double promedioPorHabitante = Math.round((totalAguaConsumida() / numeroHabitantes)*100.0)/100.0;
        System.out.println("\n Habiendo " + numeroHabitantes + " habitantes listados, el promedio de consumo por persona sería "
                + promedioPorHabitante + " Litros");
        return promedioPorHabitante;
    }

    @Override
    public Integer totalHabitantes(){
        logger.info("calculando total de habitantes");
        Integer habitantesTotal=0;
        for (Register registroConsumoAgua : this.registerRepository.findAllRegisters()) {
            habitantesTotal = habitantesTotal + registroConsumoAgua.numeroHabitantes();
        }
        return habitantesTotal;
    }

    @Override
    public Double mediaDeHabitantesPorVivienda() {
        logger.info("Calculando media de habitantes por vivienda ");
        System.out.println("\n----Media de habitantes por vivienda----");
        Double promediodeHabitantes = totalHabitantes() / (double) this.registerRepository.findAllRegisters().size();
        System.out.println("\n En la comunidad hay un promedio de " + promediodeHabitantes + " habitantes por vivienda");
        return promediodeHabitantes;
    }

    @Override
    public Double medianaDeHabitantes() {
        logger.info( "Calculando mediana de habitantes" );
        System.out.println("\n----Mediana de habitantes----");
        String medianaHabitantes = "";

        if (this.registerRepository.findAllRegisters().size() % 2 == 0) {
            int posicion1 = this.registerRepository.findAllRegisters().size() / 2 - 1;
            int posicion2 = this.registerRepository.findAllRegisters().size() / 2;
            medianaHabitantes = "" + (((this.registerRepository.findAllRegisters().get(posicion1).numeroHabitantes() * 1.0) +
                    this.registerRepository.findAllRegisters().get(posicion2).numeroHabitantes()) / 2);
        } else {
            int posicion = (this.registerRepository.findAllRegisters().size() - 1) / 2;
            medianaHabitantes = "" + this.registerRepository.findAllRegisters().get(posicion).numeroHabitantes();
        }
        System.out.println("\n La mediana de habitantes por hogar es: " + medianaHabitantes);
        return Double.parseDouble(medianaHabitantes);
        
    }

    @Override
    public Integer modaDeHabitantesPorHogar() {
        logger.info("calculando moda de habitantes por hogar");
        System.out.println("\n----La moda de habitantes por hogar----");
        int maximoNumRepeticiones = 0;
        List<Integer> moda = new ArrayList<>();

        for (int i = 0; i < this.registerRepository.findAllRegisters().size(); i++) {
            int contadorRepeticiones = 0;
            for (int j = 0; j < this.registerRepository.findAllRegisters().size(); j++) {
                if (this.registerRepository.findAllRegisters().get(i).numeroHabitantes() == this.registerRepository.findAllRegisters().get(j).numeroHabitantes()) {
                    contadorRepeticiones++;
                }
            }
            if (contadorRepeticiones > maximoNumRepeticiones) {
                moda.clear();
                moda.add(this.registerRepository.findAllRegisters().get(i).numeroHabitantes());
                maximoNumRepeticiones = contadorRepeticiones;
            } else if (contadorRepeticiones == maximoNumRepeticiones && !moda.contains(this.registerRepository.findAllRegisters().get(i).numeroHabitantes())) {
                moda.add(this.registerRepository.findAllRegisters().get(i).numeroHabitantes());
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
        logger.info("Comprobando registros desactualizados");
        System.out.println("\n----Registros desactualizados----");
        System.out.println("\n Las siguientes viviendas tienen registros anteriores a el 2023-08-14:");
        Integer count = 0;
        for (Register registroConsumoAgua : this.registerRepository.findAllRegisters()){
            if (registroConsumoAgua.fechaUltimaMedicion().isBefore(LocalDate.parse("14/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")))) {
                System.out.println(registroConsumoAgua.direccion()+"\túltimo registro: "+registroConsumoAgua.fechaUltimaMedicion());
                count++;
            }
        }
        return count;
    }

    public List<Register> listAllRegisters(){
        return this.registerRepository.findAllRegisters();
    }

    public Register addRegister(Register newRegister){
        return this.registerRepository.addRegister(newRegister);
    }

}

