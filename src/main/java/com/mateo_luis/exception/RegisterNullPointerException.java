package com.mateo_luis.exception;

import com.mateo_luis.model.Register;

import java.util.List;

public class RegisterNullPointerException extends Exception{

    public RegisterNullPointerException(List<Register> listaDeRegistros){
        System.out.println("La lista está vacía.");
    }
}
