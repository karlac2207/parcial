/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;


import edu.co.sergio.mundo.vo.Exercises;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabian.giraldo
 */
public class DAOExercises implements IBaseDatos<Exercises>  {

    @Override
    public List<Exercises> findAll() {
        List<Exercises> Exercises = null;
        String query = "SELECT * FROM Ejercicio";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOExercises.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
  
            String topic = null;
            int maxpt = 0;

            while (rs.next()) {
                if (Exercises == null) {
                    Exercises = new ArrayList<Exercises>();
                }

                Exercises ejercicio = new Exercises();
                topic = rs.getString("topic");
                ejercicio.setTopic(topic);

                maxpt = rs.getInt ("maxpt");
                ejercicio.setMaxpt (maxpt);
           
                

                Exercises.add(ejercicio);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return Exercises;

    }

    @Override
    public boolean insert(Exercises t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Exercises t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Exercises t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
