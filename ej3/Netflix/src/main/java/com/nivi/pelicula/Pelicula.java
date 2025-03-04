/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.pelicula;

import java.time.Year;
import lombok.Data;

/**
 *
 * @author nicov
 */
@Data
public class Pelicula {

    private String titulo;  //Titulo de la pelicula
    private String año;       //Año de estreno
    private String nacion;  //Pais de origen
    private String idioma;  //Idioma original
    private int color;      //1: color, 0: B/W
    private String resumen; //Sinopsis
    private String nombre ; //Nombre del director
    
    public String getAnio(){
        return año;
    }
}
