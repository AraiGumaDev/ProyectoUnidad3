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

    private Register buildRegister(String plainTextRegister){
        String[] questionArray = plainTextRegister.split(",");
        Register register = new Register( questionArray[0], Integer.valueOf(questionArray[1]), Integer.valueOf(questionArray[2]), LocalDate.parse( questionArray[3], DateTimeFormatter.ofPattern("dd/MM/uuuu")), Double.valueOf(questionArray[4]));

        return register;
    }

    @Override
    public List<Register> findAllRegisters() {
        return registerList;
    }

    @Override
    public Optional<Register> getRegister(String direccion) {
        return this.registerList.stream().filter( p->p.direccion().equals( direccion ) ).findAny();
    }

    @Override
    public Register addRegister(Register newRegister) {
        logger.info( "Añadiendo un nuevo registro" );
        this.registerList.add( newRegister );

        return this.registerList.stream()
                .filter( isTheRegisterOfTheProject( newRegister ) )
                .findAny()
                .orElse( null );//
    }

    private Predicate<Register> isTheRegisterOfTheProject(Register newRegister) {
        return p -> p.direccion().equals( newRegister.direccion() );
    }
}

