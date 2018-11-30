/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crunchify.jsp.servlet;

import edu.co.sergio.mundo.dao.DAOExercises;
import edu.co.sergio.mundo.dao.DAOStudents;
import edu.co.sergio.mundo.dao.DAOResults;
import edu.co.sergio.mundo.vo.Exercises;
import edu.co.sergio.mundo.vo.Students;
import edu.co.sergio.mundo.vo.Results;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletStudents extends  HttpServlet{
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         DAOExercises daoEscuela = new DAOExercises();
         List<Exercises> escuelas= daoEscuela.findAll();
         request.setAttribute("estudiantes", escuelas);
         //Redireccionando la informacion
         RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
         redireccion.forward(request, response);      
      
     }
     
     
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         DAOStudents daoEstudiante = new DAOStudents();
         String escuela = request.getParameter("escuela");
         List<Students> estudiantes= daoEstudiante.findAllByEscuela(Integer.parseInt(escuela));
         request.setAttribute("estudiantes", estudiantes);
         //Redireccionando la informacion
         RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
         redireccion.forward(request, response);      
         
      
     }
     
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         DAOResults daoEstudiante = new DAOResults();
         String Results = request.getParameter("resultados");
         List<Results> resultados= daoEstudiante.findAllByEscuela(Integer.parseInt(Results));
         request.setAttribute("resultados", Results);
         //Redireccionando la informacion
         RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
         redireccion.forward(request, response);      
         
      
     }
}
