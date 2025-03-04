/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.user;

import static com.nivi.user.UserControlador.registraLog;
import org.sql2o.Connection;
import util.Sql2oDAO;

/**
 *
 * @author nicov
 */
public class UserDAO {

    public void watch(String movie) {
        String watchSql = "INSERT INTO VISUALIZACION VALUES ('nico', '" + movie + "');";
        
        
        try (Connection con = Sql2oDAO.getSql2o().open()) {
            con.createQuery(watchSql).executeUpdate();
            
        } catch (Exception e) {
            registraLog.error("Error watch con {}", watchSql, e);
        }
    }
}
