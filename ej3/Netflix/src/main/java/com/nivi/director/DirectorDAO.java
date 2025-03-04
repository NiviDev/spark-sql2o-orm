/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.director;

import static com.nivi.director.DirectorControlador.registraLog;
import java.util.List;
import org.sql2o.Connection;
import util.Sql2oDAO;

/**
 *
 * @author nicov
 */
public class DirectorDAO {

    //Devuelve las nacionalidades de los actores a los que dirigió el director
    public List<String> nacActorsDirected(String director) {
        String nacActorsDirectedSql = "SELECT A.nacion "
                + "FROM ACTOR A, REPARTO R "
                + "WHERE "
                + "    A.nombre = R.nombre "
                + "        AND R.titulo IN (SELECT "
                + "            P.titulo "
                + "        FROM "
                + "            PELICULA P "
                + "        WHERE "
                + "            P.nombre = '" + director + "') "
                + "GROUP BY A.nacion;";

        List<String> nationalities = null;

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            nationalities = con.createQuery(nacActorsDirectedSql).executeAndFetch(String.class);
        } catch (Exception e) {
            registraLog.error("Error directedBy con {}", nacActorsDirectedSql, e);
        }
        return nationalities;
    }
}
