/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.nivi.plataforma10;

import com.nivi.pasaje.PasajeControlador;
import com.nivi.viaje.ViajeControlador;
import util.Path;
import static spark.Spark.*;

/**
 *
 * @author nicov
 */
public class Plataforma10 {

    public static void main(String[] args) {
        get(Path.Web.MAIN, Vista.getMainPage);
        get(Path.Web.VIAJES, ViajeControlador.selectViaje);
        get(Path.Web.FORMCOMPRA, PasajeControlador.formularioCompra);
        get(Path.Web.COMPRARPASAJE, PasajeControlador.comprarPasaje);
    }
}
