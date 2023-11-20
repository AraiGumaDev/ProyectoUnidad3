package com.mateo_luis.controller;


import java.util.List;
import com.mateo_luis.model.Register;
import com.mateo_luis.repository.RegisterUsingFileRepositoryImpl;
import com.mateo_luis.service.ConsumptionRegisterService;
import com.mateo_luis.service.ConsumptionRegisterServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/registers/")
@CrossOrigin(origins = "*")

public class RegisterController {
    Logger logger = LoggerFactory.getLogger(RegisterController.class);
    ConsumptionRegisterService consumptionRegisterService = new ConsumptionRegisterServiceImpl(new RegisterUsingFileRepositoryImpl());
    @GetMapping
    public List<Register> listRegister(){

        logger.info("Listando Registros");
        List<Register> registerList = consumptionRegisterService.listAllRegisters();
        return  registerList;
    }

    @PostMapping
    public ResponseEntity<Register> addRegister(@RequestBody Register newRegister){
        logger.info("adding Register");

        Register register = consumptionRegisterService.addRegister(newRegister);
        return ResponseEntity.status( HttpStatus.OK).body(register);
    }

}
