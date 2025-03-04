/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.restaurante;

import static com.nivi.restaurante.RestauranteControlador.registraLog;
import java.util.List;
import org.sql2o.Connection;
import util.Sql2oDAO;

/**
 *
 * @author nicov
 */
public class RestauranteDAO {

    public List<Restaurante> selectAll() {
        String selectAllSql = "SELECT * FROM RESTAURANTE;";

        List<Restaurante> restaurantes = null;

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            restaurantes = con.createQuery(selectAllSql).executeAndFetch(Restaurante.class);
        } catch (Exception e) {
            registraLog.error("Error selectAll con {}", selectAllSql, e);
        }
        return restaurantes;
    }

    public Restaurante selectRestaurante(String nombre) {
        String selectRestauranteSql = "SELECT * FROM RESTAURANTE WHERE nombre = '" + nombre + "';";

        Restaurante restaurante = null;

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            restaurante = con.createQuery(selectRestauranteSql).executeAndFetchUnique(Restaurante.class);
        } catch (Exception e) {
            registraLog.error("Error selectRestaurante con {}", selectRestauranteSql, e);
        }
        return restaurante;
    }
}
