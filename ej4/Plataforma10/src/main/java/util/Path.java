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
        public static final String VIAJES = "/api/viaje/selectViaje";
        @Getter
        public static final String FORMCOMPRA = "/api/pasaje/formularioCompra";
        @Getter
        public static final String COMPRARPASAJE = "/api/pasaje/comprarPasaje";
    }
}
