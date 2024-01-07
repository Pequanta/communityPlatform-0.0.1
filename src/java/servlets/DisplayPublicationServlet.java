/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dataContainers.Publication;
import dataContainers.UserInfo;
import databaseHandlers.CreateConnection;
import databaseHandlers.DataBaseInformationQueries;
import databaseHandlers.DataBasePublicationQueries;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author quantap
 */
public class DisplayPublicationServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try{
            PrintWriter out = response.getWriter();
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("publicationContPage.jsp");
            CreateConnection instCon = new CreateConnection();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cont = DriverManager.getConnection(instCon.getUrl() + instCon.getDatabase(), instCon.getUser(), instCon.getPassword());
            
            DataBasePublicationQueries inst = new DataBasePublicationQueries(cont);
            int pub_id = Integer.parseInt((String)request.getAttribute("pubId"));
            Publication pubContent = new Publication();
            ArrayList<String> allPub = inst.allPublications();
            for(int i = 0; i< allPub.size();i++){
                if((allPub.get(i)).split(",")[0].equals(pub_id + "")){
                    pubContent = inst.publicationInfo(pub_id);
                }
            }
            request.setAttribute("text_h", pubContent.getPublicationText());
            dispatcher.forward(request, response);
            cont.close();
            
        }catch(Exception e){
                
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