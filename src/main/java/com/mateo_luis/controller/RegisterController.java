package com.mateo_luis.controller;

import java.sql.SQLOutput;
import java.util.List;
import com.mateo_luis.model.Register;
import com.mateo_luis.repository.RegisterUsingFileRepositoryImpl;
import com.mateo_luis.service.ConsumptionRegisterService;
import com.mateo_luis.service.ConsumptionRegisterServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registers/")
@CrossOrigin(origins = "*")

public class RegisterController {
    ConsumptionRegisterService consumptionRegisterService = new ConsumptionRegisterServiceImpl(new RegisterUsingFileRepositoryImpl());
    @GetMapping
    public List<Register> listRegister(){

        System.out.println("Listando Registros");
        List<Register> registerList = consumptionRegisterService.listAllRegisters();
        return  registerList;
    }

    @PostMapping
    public ResponseEntity<Register> addRegister(@RequestBody Register newRegister){
        System.out.println("adding Register");
        Register register = consumptionRegisterService.addRegister(newRegister);
        return ResponseEntity.status( HttpStatus.OK).body(register);
    }

}
