/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dataContainers.UserInfo;
import databaseHandlers.CreateConnection;
import java.sql.Connection;
import databaseHandlers.DataBaseInformationQueries;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.DriverManager;

/**
 *
 * @author quantap
 */
public class VerifyRegistration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("verficationPage.jsp");
            String userCode = (String) request.getParameter("ver_code");
            PrintWriter out = response.getWriter();
            String verCode = (String) request.getSession().getAttribute("verificationCode");
            try{
                if(userCode.equals(verCode)){
                    CreateConnection instCon = new CreateConnection();
                    Connection cont = DriverManager.getConnection(instCon.getUrl() + instCon.getDatabase(), instCon.getUser(), instCon.getPassword());
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    UserInfo userData = (UserInfo) request.getSession().getAttribute("person");
                    DataBaseInformationQueries inst = new DataBaseInformationQueries(cont);
                    
                    boolean doneRegister = inst.addUser(userData);
                    if(doneRegister){
                        request.getSession().invalidate();
                        response.sendRedirect("signin.jsp");
                    }
                    else{
                        request.setAttribute("error_message", "Couldn't done the registration");   
                        dispatcher.forward(request, response);
                    }
                }else{
                    request.setAttribute("error_message", "Invalid Code! try Again");   
                    dispatcher.forward(request, response);
                } 
            }catch(Exception e){
                out.println("<h1>" + e.getMessage() + "</h1>");
                e.printStackTrace();
            }
            
            
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
