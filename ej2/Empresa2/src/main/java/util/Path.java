/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import lombok.Getter;

/**
 *
 * @author nicov
 */
public class Path {

    public static class Web {
        
        @Getter
        public static final String MAIN_PAGE = "/api";
        @Getter
        public static final String AREAS = "/api/area/getTodas";
        @Getter
        public static final String AREAS_DIRECTOR = "/api/area/getAreasDirector";
        @Getter
        public static final String AREAS_C_EMPLEADOS = "/api/area/getAreasConEmpleados";
        @Getter
        public static final String ADD_AREA = "/api/area/addArea";
        @Getter
        public static final String CANT_EMPL = "/api/area/getCantEmpl";
        @Getter
        public static final String DEDICACION = "/api/empleado/getPorDedicacion";
        @Getter
        public static final String EMPLEADOS_X_AREA = "/api/empleado/getPorArea";
        @Getter
        public static final String EMPLEADOS_DIRECT = "/api/empleado/getDirectores";
        @Getter
        public static final String EMPLEADOS = "/api/empleado/getTodos";
        @Getter
        public static final String ADD_EMPLEADO = "/api/empleado/addEmpleado";

    }
}
