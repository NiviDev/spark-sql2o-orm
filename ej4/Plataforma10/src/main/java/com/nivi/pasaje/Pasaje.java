/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.pasaje;

import com.nivi.viaje.Viaje;
import lombok.Data;

/**
 *
 * @author nicov
 */
@Data
public class Pasaje {
    String nombrePas;
    String dia;
    int asiento;
    Viaje viaje;
}
