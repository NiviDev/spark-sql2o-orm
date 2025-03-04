/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.director;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author nicov
 */
@Data
public class Director {

    private String nombre; //Nombre completo
    private String nacion; //Pais de nacimiento
    private Date fnac;     //Fecha de nacimiento
}
