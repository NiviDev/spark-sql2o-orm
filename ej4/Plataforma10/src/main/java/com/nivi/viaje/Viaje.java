/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.viaje;

import lombok.Data;

/**
 *
 * @author nicov
 */
@Data
public class Viaje {
    private String origen;
    private String destino;
    private String hora;
    private float precio;
    private String nombreEmp;
}
