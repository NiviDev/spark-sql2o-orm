/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nivi.menu;

import static com.nivi.menu.PlatoControlador.registraLog;
import java.util.List;
import org.sql2o.Connection;
import util.Sql2oDAO;

/**
 *
 * @author nicov
 */
public class PlatoDAO {
    public List<Plato> getMenu(String restaurante) {
        String getMenuSql = "SELECT M.nombre, M.descripcion, M.precio "
                + "FROM MENU M WHERE M.nombreRes = '" + restaurante + "';";
        
        List<Plato> menu = null;
        
        try(Connection con = Sql2oDAO.getSql2o().open()){
            menu = con.createQuery(getMenuSql).executeAndFetch(Plato.class);
        }
        catch(Exception e){
            registraLog.error("Error en getMenu() con {}", getMenuSql, e);
        }
        return menu;
    }
}
