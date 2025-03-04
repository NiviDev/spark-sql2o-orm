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
        public static final String MAIN = "/api";
        @Getter
        public static final String SELECT_RESTAURANTE = "/api/restaurante/selectRestaurante";
        @Getter
        public static String GET_MENU = "/api/menu/getMenu";
    }
}
