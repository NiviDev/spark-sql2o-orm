/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.empresa.empleado;

import static com.nivi.empresa.empleado.EmpleadoControlador.registraLog;
import java.util.List;
import org.sql2o.Connection;
import util.Sql2oDAO;

/**
 *
 * @author nicov
 */
public class EmpleadoDAO {

    public List<Empleado> selectByDedication(String dedicacion) {
        String selectByDedicationSql = "SELECT * FROM ej1Empresa.Empleado "
                + "WHERE dedicacion = '" + dedicacion + "';";
        List<Empleado> res = null;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con.createQuery(selectByDedicationSql).executeAndFetch(Empleado.class);
        } catch (Exception e) {
            registraLog.error("Error selectByDedication con {}", selectByDedicationSql, e);
        }
        return res;
    }

    public List<Empleado> selectByArea(String codigo) {
        String selectByAreaSql = "SELECT * FROM Empleado "
                + "WHERE Empleado.codigo = " + codigo + ";";
        List<Empleado> res = null;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con.createQuery(selectByAreaSql).executeAndFetch(Empleado.class);
        } catch (Exception e) {
            registraLog.error("Error selectByArea con {}", selectByAreaSql, e);
        }
        return res;
    }

    public List<Empleado> selectDirectores() {
        String selectDirectoresSql = "SELECT E.nombre, E.categoria, E.dedicacion, E.codigo "
                + "FROM Empleado E "
                + "JOIN Area A ON E.nombre = A.director;";
        List<Empleado> res = null;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            res = con.createQuery(selectDirectoresSql).executeAndFetch(Empleado.class);
        } catch (Exception e) {
            registraLog.error("Error selectDirectores con {}", selectDirectoresSql, e);
        }
        return res;
    }
}
