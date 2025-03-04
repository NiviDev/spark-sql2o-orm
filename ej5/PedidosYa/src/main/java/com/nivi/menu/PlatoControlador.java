/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.menu;

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
public class PlatoControlador {

    final static Logger registraLog = LoggerFactory.getLogger(PlatoControlador.class);

    public static Route getMenu = (req, res) -> {
        PlatoDAO pDAO = new PlatoDAO();
        List<Plato> menu = pDAO.getMenu(req.queryParams("nombre"));

        HashMap model = new HashMap();
        model.put("verMenu", true);
        model.put("menu", menu);
        model.put("restaurante", req.queryParams("nombre"));
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
