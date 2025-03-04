/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.pasaje;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nivi.viaje.Viaje;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

/**
 *
 * @author nicov
 */
public class PasajeControlador {
    
    final static Logger registraLog = LoggerFactory.getLogger(PasajeControlador.class);
    public static Route formularioCompra = (request, response) -> {
        String viajeStr = request.queryParams("viaje");
        ObjectMapper mapObj = new ObjectMapper();
        HashMap model = new HashMap();
        model.put("formularioCompra", true);
        model.put("viaje", viajeStr);        
        model.put("mapObj", mapObj);
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    
    public static Route comprarPasaje = (request, response) -> {
        String viajeStr = request.queryParams("viaje");
        String nombre = request.queryParams("nombrePas");
        String dia = request.queryParams("dia");
        int asiento = Integer.parseInt(request.queryParams("asiento"));
        
        viajeStr = viajeStr.replace("\\", "");
        viajeStr = viajeStr.substring(1, viajeStr.length() - 1);
        ObjectMapper mapObj = new ObjectMapper();
        Viaje viaje = mapObj.readValue(viajeStr, Viaje.class);
        
        Pasaje pasaje = new Pasaje();
        pasaje.setNombrePas(nombre);
        pasaje.setDia(dia);
        pasaje.setAsiento(asiento);
        pasaje.setViaje(viaje);
        
        PasajeDAO pDAO = new PasajeDAO();
        
        boolean compraExitosa = pDAO.comprarPasaje(pasaje);
        
        HashMap model = new HashMap();
        
        model.put("comprarPasaje", true);
        model.put("compraExitosa", compraExitosa);
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
