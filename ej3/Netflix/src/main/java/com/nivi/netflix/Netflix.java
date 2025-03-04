/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.nivi.netflix;

import com.nivi.director.DirectorControlador;
import com.nivi.pelicula.PeliculaControlador;
import com.nivi.user.UserControlador;
import spark.Spark;
import util.Path;
import static spark.Spark.*;

/**
 *
 * @author nicov
 */
public class Netflix {

    public static void main(String[] args) {
        Spark.staticFiles.location("/assets");
        get(Path.Web.DIRECTED_BY, PeliculaControlador.directedBy);
        get(Path.Web.WITH_ACTOR, PeliculaControlador.withActor);
        get(Path.Web.NAC_DIRECTED, DirectorControlador.nacActorsDirected);
        get(Path.Web.MOVIES, PeliculaControlador.getAll);
        get(Path.Web.RECOMENDED, PeliculaControlador.getRecommended);
        get(Path.Web.WATCH, UserControlador.watch);

    }
}
