package com.mateo_luis.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mateo_luis.model.Register;

public class RegisterUsingFileRepositoryImpl implements RegisterRepository {
    private static final Logger logger = LoggerFactory.getLogger( RegisterUsingFileRepositoryImpl.class);
    private List<Register> registerList;

    public RegisterUsingFileRepositoryImpl() {
        this.registerList = new ArrayList<>(loadRegisters());
    }

    private List<Register> loadRegisters(){
        logger.info( "Cargando los datos desde archivo" );
        List<String> plainTextRegisterList =  readFileWithRegisters();
        List<Register> registerList = plainTextRegisterList.stream().map( this::buildRegister ).toList();
        return registerList;
    }

    private List<String> readFileWithRegisters(){

        Path path = Paths.get( "./src/main/resources/Registros.txt");
        try (Stream<String> stream = Files.lines( path)) {
            return stream.toList();
        } catch (IOException x) {
            logger.error("IOException: {0}", x);
        }
        return Collections.emptyList();
    }

    private Register buildRegister(String plainTextGrade){

        String[] questionArray = plainTextRegister.split(",");
        Register register = new Register( questionArray[0], Integer.valueOf(questionArray[1]), Integer.valueOf(questionArray[2]), LocalDate.parse( questionArray[3], DateTimeFormatter.ofPattern("dd/MM/uuuu")), Double.valueOf(questionArray[4]));

        return register;
    }

    @Override
    public List<Register> findAllRegisters() {
        return registerList;
    }

    @Override
    public Optional<Register> getRegister(String unidad) {
        return this.registerList.stream().filter( p->p.project().equals( unidad ) ).findAny();
    }

    @Override
    public Register addRegister(Register newRegister) {
        this.registerList.add( newRegister );

        return this.registerList.stream()
                .filter( isTheRegisterOfTheProject( newRegister ) )//Busca la nota en la lista que corresponda al proyecto de la nota recien creada
                .findAny()
                .orElse( null );//Si no la encuentra devuelve nulo
    }

    private Predicate<Register> isTheRegisterOfTheProject(Register newRegister) {
        return p -> p.project().equals( newRegister.project() );
    }





    ArrayList<Register> registrosDeConsumo = new ArrayList<>();
    @Override
    public ArrayList<Register> llenarRegistroDeConsumoDeAgua() {
        registrosDeConsumo.add(new Register("Calle 45 Sur",2,2, LocalDate.parse("19/08/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")),13290D));
        registrosDeConsumo.add(new Register("Calle 22 Sur", 2, 5, LocalDate.parse("13/09/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 33780D));
        registrosDeConsumo.add(new Register("Calle 82 Sur", 3, 1, LocalDate.parse("19/03/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 6180D));
        registrosDeConsumo.add(new Register("Calle 81 Sur", 3, 4, LocalDate.parse("20/08/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 24690D));
        registrosDeConsumo.add(new Register("Carrera 13", 1, 5, LocalDate.parse("11/09/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 31500D));
        registrosDeConsumo.add(new Register("Calle 12", 2, 3, LocalDate.parse("01/09/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 17953D));
        registrosDeConsumo.add(new Register("Avenida 33", 3, 6, LocalDate.parse("21/08/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 35606D));
        registrosDeConsumo.add(new Register("Calle 64", 4, 3, LocalDate.parse("30/08/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 18175D));
        registrosDeConsumo.add(new Register("Carrera 94", 5, 4, LocalDate.parse("24/08/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 24578D));
        registrosDeConsumo.add(new Register("Avenida 11", 1, 1, LocalDate.parse("02/07/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 7153D));
        registrosDeConsumo.add(new Register("Carrera 23", 2, 5, LocalDate.parse("11/09/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 29679D));
        registrosDeConsumo.add(new Register("Calle 35", 3, 4, LocalDate.parse("09/09/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 22346D));
        registrosDeConsumo.add(new Register("Avenida 8", 4, 4, LocalDate.parse("27/08/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 23433D));
        registrosDeConsumo.add(new Register("Carrera 73", 5, 6, LocalDate.parse("06/09/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 32876D));
        registrosDeConsumo.add(new Register("Calle 42", 1, 3, LocalDate.parse("28/08/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 17489D));
        registrosDeConsumo.add(new Register("Avenida 95", 2, 4, LocalDate.parse("12/09/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 25765D));
        registrosDeConsumo.add(new Register("Carrera 43", 3, 5, LocalDate.parse("05/09/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 29795D));
        registrosDeConsumo.add(new Register("Calle 14", 4, 2, LocalDate.parse("20/08/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 12235D));
        registrosDeConsumo.add(new Register("Avenida 57", 5, 4, LocalDate.parse("14/08/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 25133D));
        registrosDeConsumo.add(new Register("Carrera 16", 1, 1, LocalDate.parse("03/09/2023",
                DateTimeFormatter.ofPattern("dd/MM/uuuu")), 6549D));
        return registrosDeConsumo;
    }
}

