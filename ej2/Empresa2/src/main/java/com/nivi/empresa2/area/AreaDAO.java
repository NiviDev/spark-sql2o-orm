/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.empresa2.area;

import static com.nivi.empresa2.area.AreaControlador.registraLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.sql2o.Connection;
import util.Pair;
import util.Sql2oDAO;

/**
 *
 * @author nicov
 */

public class AreaDAO {

    public List<Area> selectAll() {
        String selectAllSql = "SELECT * FROM ej1Empresa.Area;";
        List<Area> res = null;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con.createQuery(selectAllSql).executeAndFetch(Area.class);
        } catch (Exception e) {
            registraLog.error("Error selectAll con {}", selectAllSql, e);
        }
        return res;
    }

    public List<Area> selectDirectedBy(String director) {
        String selectDirectedBySql = "SELECT * FROM ej1Empresa.Area "
                + "WHERE director = '" + director + "';";
        List<Area> res = null;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con.createQuery(selectDirectedBySql).executeAndFetch(Area.class);
        } catch (Exception e) {
            registraLog.error("Error selectDirectedBy con {}", selectDirectedBySql, e);
        }
        return res;
    }

    public List<Area> selectConEmpleados() {
        String selectConEmpleadosSql = "SELECT DISTINCT A.codigo, A.nombre, A.director "
                + "FROM Area A "
                + "JOIN Empleado E ON A.codigo = E.codigo;";
        List<Area> res = null;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con.createQuery(selectConEmpleadosSql).executeAndFetch(Area.class);
        } catch (Exception e) {
            registraLog.error("Error selectConEmpleados con {}", selectConEmpleadosSql, e);
        }
        return res;
    }

    public boolean addArea(Area a) {
        String addAreaSql = "INSERT INTO Area (codigo, nombre, director) "
                + "VALUES (:codigo, :nombre, :director);";
        boolean exito = false;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(addAreaSql)
                    .addParameter("codigo", a.getCodigo())
                    .addParameter("nombre", a.getNombre())
                    .addParameter("director", a.getDirector())
                    .executeUpdate();
            exito = true;
        } catch (Exception e) {
            registraLog.error("Error addArea con {}", addAreaSql, e);
        }
        return exito;
    }

    public List<Pair> getCantEmpl() {
        String getCantEmplSql = "SELECT Area.nombre as 'key', Count(Empleado.codigo) as 'value' "
                + "FROM Empleado "
                + "INNER JOIN Area ON Empleado.codigo=Area.Codigo "
                + "GROUP BY Empleado.codigo;";
        
        List<Pair> res = null;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con.createQuery(getCantEmplSql).executeAndFetch(Pair.class);

        } catch (Exception e) {
            registraLog.error("Error getCantEmpl con {}", getCantEmplSql, e);
        }
        return res;
    }

}
