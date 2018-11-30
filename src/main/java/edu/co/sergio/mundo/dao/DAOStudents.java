/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;


import edu.co.sergio.mundo.vo.Students;
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
 * @author fabian.giraldo
 */
public class DAOStudents implements IBaseDatos<Students>{

  
    public List<Students> findAllByEscuela(int codigo) {
        List<Students> estudiantes = null;
        String query = "Select * from  Students)";
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
            int id = 0;
            String nombre = null, apellido = null, email = null;

            while (rs.next()) {
                if (estudiantes == null) {
                    estudiantes = new ArrayList<Students>();
                }

                Students estudiante = new Students();
                id = rs.getInt("codigo");
                estudiante.setCodigo(id);

                nombre = rs.getString("nombre");
                estudiante.setNombre(nombre);
                
                apellido = rs.getString("apellido");
                estudiante.setApellido(apellido);
                
                email =rs.getString("email");
                estudiante.setEmail(email);
                
                estudiantes.add(estudiante);
            }
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return estudiantes;

    }

    @Override
    public boolean insert(Students t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Students t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Students t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Students> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
