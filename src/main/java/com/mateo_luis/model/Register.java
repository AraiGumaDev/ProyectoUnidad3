package com.mateo_luis.model;

import java.time.LocalDate;

public record Register(String direccion,
                       Integer estrato,
                       Integer numeroHabitantes,
                       LocalDate fechaUltimaMedicion,
                       Double consumoAguaMes) {}
