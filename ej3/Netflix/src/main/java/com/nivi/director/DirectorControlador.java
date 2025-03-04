/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.director;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

/**
 *
 * @author nicov
 */
public class DirectorControlador {

    final static Logger registraLog = LoggerFactory.getLogger(DirectorControlador.class);

    public static Route nacActorsDirected = (Request request, Response response) -> {
        DirectorDAO dDAO = new DirectorDAO();
        List<String> nationalities = dDAO.nacActorsDirected(request.queryParams("search"));
        
        HashMap model = new HashMap();
        model.put("nationalities", nationalities); 
        model.put("director", request.queryParams("search"));
        model.put("directores", true);
        model.put("template", "templates/index.vtl");
        

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
