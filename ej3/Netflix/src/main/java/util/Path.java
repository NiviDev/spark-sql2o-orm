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
        public static final String DIRECTED_BY = "/netflix/peliculas/directedBy";
        @Getter
        public static final String WITH_ACTOR = "/netflix/peliculas/withActor";
        @Getter
        public static final String MOVIES = "/netflix/peliculas";
        @Getter
        public static final String NAC_DIRECTED = "/netflix/director/nacActorsDirected";
        @Getter
        public static final String RECOMENDED = "/netflix/peliculas/recomendaciones";
        @Getter
        public static final String WATCH = "/netflix/user/watch";
    }
}
