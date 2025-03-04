/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.pasaje;

import static com.nivi.pasaje.PasajeControlador.registraLog;
import org.sql2o.Connection;
import util.Sql2oDAO;

/**
 *
 * @author nicov
 */
public class PasajeDAO {

    public boolean comprarPasaje(Pasaje p) {
        String comprarPasajeSql = "INSERT INTO PASAJE "
                + "VALUES (:nombrePas, :dia, :hora, :asiento, :origen, :destino, :nombreEmp);";
        boolean exito = false;
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(comprarPasajeSql)
                    .addParameter("nombrePas", p.getNombrePas())
                    .addParameter("dia", p.getDia())
                    .addParameter("hora", p.getViaje().getHora())
                    .addParameter("asiento", p.getAsiento())
                    .addParameter("origen", p.getViaje().getOrigen())
                    .addParameter("destino", p.getViaje().getDestino())
                    .addParameter("nombreEmp", p.getViaje().getNombreEmp())
                    .executeUpdate();
            exito = true;
        } catch (Exception e) {
            registraLog.error("Error comprarPasaje con {}", comprarPasajeSql, e);
        }
        return exito;
    }
}
