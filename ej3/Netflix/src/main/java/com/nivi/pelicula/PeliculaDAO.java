/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.pelicula;

import java.util.List;
import org.sql2o.Connection;
import static com.nivi.pelicula.PeliculaControlador.registraLog;
import util.Sql2oDAO;

/**
 *
 * @author nicov
 */
public class PeliculaDAO {

    public List<Pelicula> directedBy(String director) {
        String directedBySql = "SELECT * FROM PELICULA WHERE PELICULA.nombre = '" + director + "';";

        List<Pelicula> directed = null;

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            directed = con.createQuery(directedBySql).executeAndFetch(Pelicula.class);
        } catch (Exception e) {
            registraLog.error("Error directedBy con {}", directedBySql, e);
        }
        return directed;
    }

    public List<Pelicula> withActor(String actor) {
        String withActorSql = "SELECT P.* "
                + "FROM PELICULA P "
                + "JOIN REPARTO R ON P.titulo = R.titulo "
                + "WHERE R.nombre = '" + actor + "';";

        List<Pelicula> actedIn = null;

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            actedIn = con.createQuery(withActorSql).executeAndFetch(Pelicula.class);
        } catch (Exception e) {
            registraLog.error("Error withActor con {}", withActorSql, e);
        }
        return actedIn;
    }

    public List<Pelicula> getAll() {
        String getAllSql = "SELECT * FROM PELICULA;";

        List<Pelicula> peliculas = null;

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            peliculas = con.createQuery(getAllSql).executeAndFetch(Pelicula.class);
        } catch (Exception e) {
            registraLog.error("Error getAll con {}", getAllSql, e);
        }
        return peliculas;
    }

    public List<Pelicula> getRecommended() {
        String getRecommendedSql = "SELECT * "
                + "FROM PELICULA "
                + "WHERE nombre IN ( "
                + "    SELECT nombre "
                + "    FROM PELICULA "
                + "    WHERE titulo IN ("
                + "        SELECT titulo "
                + "        FROM VISUALIZACION "
                + "        WHERE username = 'nico'"
                + "    )"
                + ")"
                + "AND titulo NOT IN ("
                + "    SELECT titulo "
                + "    FROM VISUALIZACION "
                + "    WHERE username = 'nico'"
                + ");";

        List<Pelicula> peliculas = null;

        try (Connection con = Sql2oDAO.getSql2o().open()) {
            peliculas = con.createQuery(getRecommendedSql).executeAndFetch(Pelicula.class);
        } catch (Exception e) {
            registraLog.error("Error getRecommended con {}", getRecommendedSql, e);
        }
        return peliculas;
    }
}
