/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.empresa.area;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author nicov
 */
public class AreaControlador {

    final static Logger registraLog = LoggerFactory.getLogger(AreaControlador.class);

    public static Route getTodos = (Request request, Response response) -> {
        AreaDAO aDAO = new AreaDAO();
        List<Area> res = aDAO.selectAll();
        ObjectMapper mapperObj = new ObjectMapper();
        return mapperObj.writeValueAsString(res);
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
}
