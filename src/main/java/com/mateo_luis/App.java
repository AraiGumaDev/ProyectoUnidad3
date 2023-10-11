package com.mateo_luis;

import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
      
      /*Este es un programa que podría usar una entidad estilo EPM para ver las 
      estádisticas y datos del consumo de los habitantes de una comunidad para 
      así generar concientización. 
      
      Este proyecto se alinea con el ODS 6 que busca que todas las personan puedan 
      tener acceso a un minímo vital de agua y se le de un correcto uso. En la comuna en la 
      que vivo últimamente hay denuncias sobre que el agua se esta usando de manera indevida
      para actividades como lavader carros, un programa como este se puede aplicar en 
      cualquier comunidad y podría ayudar a identificar quienes son los individuos que 
      hacen mal uso de este preciado recurso.*/
      
      record RegistroConsumoAgua (String direccion,
                                  Integer estrato,
                                  Integer numeroHabitantes,
                                  LocalDate fechaUltimaMedicion,
                                  Double consumoAguaMes){};
                      
      List<RegistroConsumoAgua> Registros = new ArrayList<>();
      
      Registros.add(new RegistroConsumoAgua("Calle 45 Sur",
                                            2,
                                            2,
                                            LocalDate.parse("19/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            13290D));
      Registros.add(new RegistroConsumoAgua("Calle 22 Sur",
                                            2,
                                            5,
                                            LocalDate.parse("13/09/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            33780D));
      Registros.add(new RegistroConsumoAgua("Calle 82 Sur",
                                            3,
                                            1,
                                            LocalDate.parse("19/03/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            6180D));
      Registros.add(new RegistroConsumoAgua("Calle 81 Sur",
                                            3,
                                            4,
                                            LocalDate.parse("20/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            24690D));
      Registros.add(new RegistroConsumoAgua("Carrera 13",
                                            1,
                                            5,
                                            LocalDate.parse("11/09/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            31500D));
      Registros.add(new RegistroConsumoAgua("Calle 12",
                                            2,
                                            3,
                                            LocalDate.parse("01/09/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            17953D));
      Registros.add(new RegistroConsumoAgua("Avenida 33",
                                            3,
                                            6,
                                            LocalDate.parse("21/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            35606D));
      Registros.add(new RegistroConsumoAgua("Calle 64",
                                            4,
                                            3,
                                            LocalDate.parse("30/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            18175D));
      Registros.add(new RegistroConsumoAgua("Carrera 94",
                                            5,
                                            4,
                                            LocalDate.parse("24/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            24578D));
      Registros.add(new RegistroConsumoAgua("Avenida 11",
                                            1,
                                            1,
                                            LocalDate.parse("02/07/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            7153D));
      Registros.add(new RegistroConsumoAgua("Carrera 23",
                                            2,
                                            5,
                                            LocalDate.parse("11/09/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            29679D));
      Registros.add(new RegistroConsumoAgua("Calle 35",
                                            3,
                                            4,
                                            LocalDate.parse("09/09/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            22346D));
      Registros.add(new RegistroConsumoAgua("Avenida 8",
                                            4,
                                            4,
                                            LocalDate.parse("27/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            23433D));
      Registros.add(new RegistroConsumoAgua("Carrera 73",
                                            5,
                                            6,
                                            LocalDate.parse("06/09/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            32876D));
      Registros.add(new RegistroConsumoAgua("Calle 42",
                                            1,
                                            3,
                                            LocalDate.parse("28/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            17489D));
      Registros.add(new RegistroConsumoAgua("Avenida 95",
                                            2,
                                            4,
                                            LocalDate.parse("12/09/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            25765D));
      Registros.add(new RegistroConsumoAgua("Carrera 43",
                                            3,
                                            5,
                                            LocalDate.parse("05/09/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            29795D));
      Registros.add(new RegistroConsumoAgua("Calle 14",
                                            4,
                                            2,
                                            LocalDate.parse("20/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            12235D));
      Registros.add(new RegistroConsumoAgua("Avenida 57",
                                            5,
                                            4,
                                            LocalDate.parse("14/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            25133D));
      Registros.add(new RegistroConsumoAgua("Carrera 16",
                                            1,
                                            1,
                                            LocalDate.parse("03/09/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")),
                                            6549D));
      
      /*Aclaración: El tema de algoritmos de ordenamiento ya lo vimos en 
      Lógica II que es correquisito de esta materia y lo quise implementar
      
      Teniendo como referencia la variable numeroHabitantes, ordenamos
      los registros de menor a mayor para operar con mayor facilidad*/

      boolean intercambio;
      for (int i = 0; i < Registros.size() - 1; i++) {
          intercambio = false;
      
          for (int j = 0; j < Registros.size() - i - 1; j++) {
              if (Registros.get(j).numeroHabitantes > Registros.get(j + 1).numeroHabitantes) {
                  RegistroConsumoAgua temp = Registros.get(j);
                  Registros.set(j, Registros.get(j + 1));
                  Registros.set(j + 1, temp);
                  intercambio = true;
              }
          }
          if (!intercambio) {
              break;
          }
      }
      
      System.out.println("----Media de consumo por vivienda----");
      Double totalAguaConsumida = 0D;
      for (RegistroConsumoAgua registroConsumoAgua : Registros) {
        totalAguaConsumida = totalAguaConsumida + registroConsumoAgua.consumoAguaMes;
      }
      Double promedioPorVivienda = totalAguaConsumida / Registros.size();
      System.out.println("En total las " + Registros.size() + " viviendas listadas consumieron: " + totalAguaConsumida + " Litros");
      System.out.println("Lo que da un promedio por vivienda de: " + promedioPorVivienda + " Litros");
    
      System.out.println("\n----Media de consumo por habitante----");
      Integer totalHabitantes = 0;
      for (RegistroConsumoAgua registroConsumoAgua : Registros) {
        totalHabitantes = totalHabitantes + registroConsumoAgua.numeroHabitantes;
      }
      Double promedioPorHabitante = Math.round((totalAguaConsumida / totalHabitantes)*100.0)/100.0;
      System.out.println("Habiendo " + totalHabitantes + " habitantes listados, el promedio de consumo por persona sería: " + promedioPorHabitante + " Litros");
    
      System.out.println("\n----Media de habitantes por vivienda----");
      Double promediodeHabitantes = totalHabitantes / Double.valueOf(Registros.size());
      System.out.println("En la comunidad hay un promedio de " + promediodeHabitantes + " habitantes por vivienda");
    
      System.out.println("\n----Mediana de habitantes----");
      /*Ya que no hemos visto cómo convertir entre clases, opté por manejar la variable
      medianaHabitantes como un String para facilitarme las cosas*/
      String medianaHabitantes = "";

      if (Registros.size() % 2 == 0) {
        int posicion1 = Registros.size() / 2 - 1;
        int posicion2 = Registros.size() / 2;
        medianaHabitantes = "" + (((Registros.get(posicion1).numeroHabitantes * 1.0) + Registros.get(posicion2).numeroHabitantes) / 2);
      } else {
        int posicion = (Registros.size() - 1) / 2;
        medianaHabitantes = "" + Registros.get(posicion).numeroHabitantes;
      }
      System.out.println("La mediana de habitantes por hogar es: " + medianaHabitantes);
      
      System.out.println("\n----La moda de habitantes por hogar----");
      int maximoNumRepeticiones = 0;
      List<Integer> moda = new ArrayList<>();
      
      for (int i = 0; i < Registros.size(); i++) {
          int contadorRepeticiones = 0;
          for (int j = 0; j < Registros.size(); j++) {
              if (Registros.get(i).numeroHabitantes == Registros.get(j).numeroHabitantes) {
                  contadorRepeticiones++;
              }
          }
          if (contadorRepeticiones > maximoNumRepeticiones) {
              moda.clear();
              moda.add(Registros.get(i).numeroHabitantes);
              maximoNumRepeticiones = contadorRepeticiones;
          } else if (contadorRepeticiones == maximoNumRepeticiones && !moda.contains(Registros.get(i).numeroHabitantes)) {
              moda.add(Registros.get(i).numeroHabitantes);
          }
      }
      
      System.out.print("La moda de habitantes por hogar es: ");
      for (int i = 0; i < moda.size(); i++) {
          System.out.print(moda.get(i));
          if (i < moda.size() - 2) {
              System.out.print(" ");
          } else if (i == moda.size() - 2) {
              System.out.print(" y ");
          }
      }
      System.out.println(" que se repitieron " + maximoNumRepeticiones + " veces.");
      
      System.out.println("\n----Registros desactualizados----");
      System.out.println("Las siguientes viviendas tienen registros anteriores a el 2023-08-14:");
      for (RegistroConsumoAgua registroConsumoAgua : Registros){
        /*Aquí use el metodo isBefore ya que con el operador < no me dejaba comparar,
        me gustaria saber si hay otra forma de hacerlo*/
        if (registroConsumoAgua.fechaUltimaMedicion.isBefore(LocalDate.parse("14/08/2023", DateTimeFormatter.ofPattern("dd/MM/uuuu")))) {
          System.out.println(registroConsumoAgua.direccion+"\túltimo registro: "+registroConsumoAgua.fechaUltimaMedicion);
        }
      }
  }
}
