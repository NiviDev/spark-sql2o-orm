/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.pelicula;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

/**
 *
 * @author nicov
 */
public class PeliculaControlador {
    
    final static Logger registraLog = LoggerFactory.getLogger(PeliculaControlador.class);

    public static Route directedBy = (Request request, Response response) -> {
        PeliculaDAO pDAO = new PeliculaDAO();
        List<Pelicula> peliculas = pDAO.directedBy(request.queryParams("search"));

        HashMap model = new HashMap();
        model.put("peliculas", peliculas);        
        model.put("template", "templates/index.vtl");
        

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    
    public static Route withActor = (Request request, Response response) -> {
        PeliculaDAO pDAO = new PeliculaDAO();
        List<Pelicula> peliculas = pDAO.withActor(request.queryParams("search"));

        HashMap model = new HashMap();
        model.put("peliculas", peliculas);        
        model.put("template", "templates/index.vtl");
        

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    
    public static Route getAll = (Request request, Response response) -> {
        PeliculaDAO pDAO = new PeliculaDAO();
        List<Pelicula> peliculas = pDAO.getAll();

        HashMap model = new HashMap();
        model.put("peliculas", peliculas);        
        model.put("template", "templates/index.vtl");
        

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    
    public static Route getRecommended = (Request request, Response response) -> {
        PeliculaDAO pDAO = new PeliculaDAO();
        List<Pelicula> peliculas = pDAO.getRecommended();

        HashMap model = new HashMap();
        model.put("peliculas", peliculas);
        model.put("recommended", true);
        model.put("template", "templates/index.vtl");
        

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
