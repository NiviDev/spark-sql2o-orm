/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.empresa.empleado;

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
public class EmpleadoControlador {

    final static Logger registraLog = LoggerFactory.getLogger(EmpleadoControlador.class);
    public static Route getPorDedicacion = (Request request, Response response) -> {
        EmpleadoDAO eDAO = new EmpleadoDAO();
        List<Empleado> res = eDAO.selectByDedication(request.queryParams("dedicacion"));
        ObjectMapper mapperObj = new ObjectMapper();
        return mapperObj.writeValueAsString(res);
    };

    public static Route getPorArea = (Request request, Response response) -> {
        EmpleadoDAO eDAO = new EmpleadoDAO();
        List<Empleado> res = eDAO.selectByArea(request.queryParams("codigo"));
        ObjectMapper mapperObj = new ObjectMapper();
        return mapperObj.writeValueAsString(res);
    };
    
    public static Route getDirectores = (Request request, Response response) -> {
        EmpleadoDAO eDAO = new EmpleadoDAO();
        List<Empleado> res = eDAO.selectDirectores();
        ObjectMapper mapperObj = new ObjectMapper();
        return mapperObj.writeValueAsString(res);
    };
}
