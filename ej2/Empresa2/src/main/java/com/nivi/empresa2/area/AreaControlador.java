/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.empresa2.area;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;
import util.Pair;

/**
 *
 * @author nicov
 */
public class AreaControlador {

    final static Logger registraLog = LoggerFactory.getLogger(AreaControlador.class);

    public static Route getTodos = (Request request, Response response) -> {
        AreaDAO aDAO = new AreaDAO();
        List<Area> areas = aDAO.selectAll();

        HashMap model = new HashMap();
        model.put("areas", areas);
        model.put("getAreas", true);
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route getAreasDirector = (Request request, Response response) -> {
        AreaDAO aDAO = new AreaDAO();
        List<Area> res = aDAO.selectDirectedBy(request.queryParams("director"));
        ObjectMapper mapperObj = new ObjectMapper();
        return mapperObj.writeValueAsString(res);
    };

    public static Route getAreasConEmpleados = (Request request, Response response) -> {
        AreaDAO aDAO = new AreaDAO();
        List<Area> res = aDAO.selectConEmpleados();
        ObjectMapper mapperObj = new ObjectMapper();
        return mapperObj.writeValueAsString(res);
    };
    
    public static Route getCantEmpl = (Request request, Response response) -> {
        AreaDAO aDAO = new AreaDAO();
        List<Pair> res = aDAO.getCantEmpl();
        
        HashMap model = new HashMap();
        model.put("res", res);
        model.put("cantEmpl", true);
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route addArea = (Request request, Response response) -> {
        AreaDAO aDAO = new AreaDAO();
        Area a = new Area();
        a.setCodigo(Integer.parseInt(request.queryParams("codigo")));
        a.setNombre(request.queryParams("nombre"));
        a.setDirector(request.queryParams("director"));
        boolean exito = aDAO.addArea(a);
        
        HashMap model = new HashMap();
        model.put("exitoAddArea", exito);
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
