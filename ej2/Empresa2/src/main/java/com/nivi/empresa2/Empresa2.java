/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nivi.empresa2;

import com.nivi.empresa2.area.AreaControlador;
import com.nivi.empresa2.empleado.EmpleadoControlador;
import util.Path;
import static spark.Spark.*;

/**
 *
 * @author nicov
 */
public class Empresa2 {

    public static void main(String[] args) {
        
        get(Path.Web.MAIN_PAGE, Vista.getMainPage);
        get(Path.Web.AREAS, AreaControlador.getTodos);
        get(Path.Web.AREAS_DIRECTOR, AreaControlador.getAreasDirector);
        get(Path.Web.AREAS_C_EMPLEADOS, AreaControlador.getAreasConEmpleados);
        get(Path.Web.DEDICACION, EmpleadoControlador.getPorDedicacion);
        get(Path.Web.EMPLEADOS_X_AREA, EmpleadoControlador.getPorArea);
        get(Path.Web.EMPLEADOS_DIRECT, EmpleadoControlador.getDirectores);
        get(Path.Web.ADD_AREA, AreaControlador.addArea);
        get(Path.Web.EMPLEADOS, EmpleadoControlador.getTodos);
        get(Path.Web.CANT_EMPL, AreaControlador.getCantEmpl);
        get(Path.Web.ADD_EMPLEADO, EmpleadoControlador.addEmpleado);
        
        
    }
}
