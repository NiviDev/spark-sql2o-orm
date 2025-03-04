/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.restaurante;

import java.util.ArrayList;
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
public class RestauranteControlador {
    final static Logger registraLog = LoggerFactory.getLogger(RestauranteControlador.class);
    
    public static Route selectAll = (req, res) -> {
        RestauranteDAO rDAO = new RestauranteDAO();
        List<Restaurante> restaurantes = rDAO.selectAll();
        HashMap model = new HashMap();
        model.put("verRestaurantes", true);
        model.put("restaurantes", restaurantes);
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    
    public static Route selectRestaurante = (req, res) -> {
        RestauranteDAO rDAO = new RestauranteDAO();
        Restaurante restaurante = rDAO.selectRestaurante(req.queryParams("nombre"));
        
        List<Restaurante> restaurantes = new ArrayList<>();
        
        restaurantes.add(restaurante);
        HashMap model = new HashMap();
        model.put("verRestaurantes", true);
        model.put("restaurantes", restaurantes);
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
