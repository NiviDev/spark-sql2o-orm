/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nivi.pedidosya;

import com.nivi.menu.PlatoControlador;
import com.nivi.restaurante.RestauranteControlador;
import spark.Spark;
import static spark.Spark.*;
import util.Path;

/**
 *
 * @author nicov
 */
public class PedidosYa {

    public static void main(String[] args) {
        Spark.staticFiles.location("/assets");
        get(Path.Web.MAIN, RestauranteControlador.selectAll);
        get(Path.Web.SELECT_RESTAURANTE, RestauranteControlador.selectRestaurante);
        get(Path.Web.GET_MENU, PlatoControlador.getMenu);
    }
}
