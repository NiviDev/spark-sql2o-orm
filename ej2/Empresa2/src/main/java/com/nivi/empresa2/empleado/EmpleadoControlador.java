/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.empresa2.empleado;

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
public class EmpleadoControlador {

    final static Logger registraLog = LoggerFactory.getLogger(EmpleadoControlador.class);

    public static Route getTodos = (Request request, Response response) -> {
        EmpleadoDAO eDAO = new EmpleadoDAO();
        List<Empleado> empleados = eDAO.selectAll();

        HashMap model = new HashMap();
        model.put("empleados", empleados);
        model.put("getEmpleados", true);
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
    public static Route getPorDedicacion = (Request request, Response response) -> {
        EmpleadoDAO eDAO = new EmpleadoDAO();
        List<Empleado> res = eDAO.selectByDedication(request.queryParams("dedicacion"));
        ObjectMapper mapperObj = new ObjectMapper();
        return mapperObj.writeValueAsString(res);
    };

    public static Route getPorArea = (Request request, Response response) -> {
        EmpleadoDAO eDAO = new EmpleadoDAO();
        List<Empleado> empleados = eDAO.selectByArea(request.queryParams("codigo"));

        HashMap model = new HashMap();
        model.put("empleados", empleados);
        model.put("emplDelArea", true);
        model.put("codigo", request.queryParams("codigo"));
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };

    public static Route getDirectores = (Request request, Response response) -> {
        EmpleadoDAO eDAO = new EmpleadoDAO();
        List<Empleado> res = eDAO.selectDirectores();
        ObjectMapper mapperObj = new ObjectMapper();
        return mapperObj.writeValueAsString(res);
    };

    public static Route addEmpleado = (Request request, Response response) -> {
        EmpleadoDAO eDAO = new EmpleadoDAO();
        Empleado e = new Empleado();

        e.setNombre(request.queryParams("nombre"));
        e.setCategoria(request.queryParams("categoria"));
        e.setDedicacion(request.queryParams("dedicacion"));
        e.setCodigo(Integer.parseInt(request.queryParams("area")));
        boolean exito = eDAO.addEmpleado(e);

        HashMap model = new HashMap();
        model.put("exitoAddEmpl", exito);
        model.put("template", "templates/index.vtl");

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
