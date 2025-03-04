/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.viaje;

import static com.nivi.viaje.ViajeControlador.registraLog;
import java.util.List;
import org.sql2o.Connection;
import util.Sql2oDAO;

/**
 *
 * @author nicov
 */
public class ViajeDAO {
    public List<Viaje> selectViaje(String origen, String destino){
        String selectViajeSql = "SELECT * FROM VIAJE "
                + "WHERE origen = '" + origen + "' "
                + "AND destino = '" + destino + "';";
        
        List<Viaje> viajes = null;
        try(Connection con = Sql2oDAO.getSql2o().open()){
            viajes = con.createQuery(selectViajeSql).executeAndFetch(Viaje.class);
        }catch(Exception e){
            registraLog.error("Error selectViaje con {}", selectViajeSql, e);
        }
        return viajes;
    }
}
