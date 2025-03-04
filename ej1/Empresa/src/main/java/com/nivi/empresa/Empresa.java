/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nivi.empresa;

import com.nivi.empresa.area.AreaControlador;
import com.nivi.empresa.empleado.EmpleadoControlador;
import util.Path;
import static spark.Spark.*;

/**
 *
 * @author nicov
 */
public class Empresa {

    public static void main(String[] args) {
        get(Path.Web.AREAS, AreaControlador.getTodos);
        get(Path.Web.AREAS_DIRECTOR, AreaControlador.getAreasDirector);
        get(Path.Web.AREAS_C_EMPLEADOS, AreaControlador.getAreasConEmpleados);
        get(Path.Web.DEDICACION, EmpleadoControlador.getPorDedicacion);
        get(Path.Web.EMPLEADOS_X_AREA, EmpleadoControlador.getPorArea);
        get(Path.Web.EMPLEADOS_DIRECT, EmpleadoControlador.getDirectores);
        
    }
}
