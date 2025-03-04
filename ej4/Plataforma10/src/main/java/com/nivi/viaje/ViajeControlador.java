/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.viaje;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ViajeControlador {

    final static Logger registraLog = LoggerFactory.getLogger(ViajeControlador.class);
    public static Route selectViaje = (request, response) -> {
        ViajeDAO vDAO = new ViajeDAO();
        List<Viaje> viajes = vDAO.selectViaje(request.queryParams("origen"), request.queryParams("destino"));

        ObjectMapper mapObj = new ObjectMapper();
        HashMap model = new HashMap();
        model.put("selectViaje", true);
        model.put("viajes", viajes);
        model.put("mapObj", mapObj);
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
