package com.mateo_luis.exception;

import com.mateo_luis.controller.RegisterController;
import com.mateo_luis.model.Register;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RegisterNullPointerException extends Exception{
    Logger logger = LoggerFactory.getLogger(RegisterNullPointerException.class);


    public RegisterNullPointerException(List<Register> listaDeRegistros){
        logger.error("La lista está vacía.");
    }
}
