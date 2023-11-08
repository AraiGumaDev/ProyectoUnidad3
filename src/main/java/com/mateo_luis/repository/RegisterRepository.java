package com.mateo_luis.repository;

import com.mateo_luis.model.Register;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface RegisterRepository {

    ArrayList<Register> llenarRegistroDeConsumoDeAgua();

    List<Register> findAllRegisters();
    Optional<Register> getRegister(String direccion);
    Register addRegister(Register newRegister)
}
