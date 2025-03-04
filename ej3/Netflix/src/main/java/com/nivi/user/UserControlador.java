/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.user;

import java.util.HashMap;
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
public class UserControlador {
    final static Logger registraLog = LoggerFactory.getLogger(UserControlador.class);
    
    public static Route watch = (Request request, Response response) -> {
        UserDAO uDAO = new UserDAO();
        uDAO.watch(request.queryParams("titulo"));

        HashMap model = new HashMap();
        model.put("watch", true);
        model.put("template", "templates/index.vtl");
        

        return new VelocityTemplateEngine().render(new ModelAndView(model, "templates/layout.vtl"));
    };
}
