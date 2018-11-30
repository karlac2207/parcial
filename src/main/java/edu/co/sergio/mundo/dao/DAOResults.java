/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Results;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Labing
 */
public class DAOResults implements IBaseDatos<Results>  {
    
        public List<Results> findAllByEscuela(int codigo) {
        List<Results> Results = null;
        String query = "Select * from  Results)";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement preparedStmt = null;
            preparedStmt = connection.prepareStatement(query);
	    preparedStmt.setInt (1, codigo);
            ResultSet rs = preparedStmt.executeQuery();
            int points = 0;
            String SID = null, CAT = null;
            while (rs.next()) {
                if (Results == null) {
                    Results = new ArrayList<Results>();
                }

                Results resultado = new Results();
                points = rs.getInt("codigo");
                resultado.setPoints(points);

                SID = rs.getString("sid");
                resultado.setSid(SID);
                
                CAT = rs.getString("cat");
                resultado.setCat(CAT);
                
                
                
                Results.add(resultado);
            }
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return Results;

    }

    @Override
    public boolean insert(Results t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Results t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Results t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Results> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


