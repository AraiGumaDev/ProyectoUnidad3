package com.mateo_luis.repository;
import com.mateo_luis.model.Register;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RegisterInMemoryRepositoryImpl implements RegisterMemory{

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

