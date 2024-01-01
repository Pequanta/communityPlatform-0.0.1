/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import dataContainers.ChatInfo;
import dataContainers.UserInfo;
import databaseHandlers.CreateConnection;
import databaseHandlers.DataBaseDiscussionQueries;
import databaseHandlers.DataBaseInformationQueries;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

/**
 *
 * @author quantap
 */
public class SendMessageServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try{
                
                String newMessage = request.getParameter("message");
                RequestDispatcher dispatcher = request.getRequestDispatcher("chat_room.jsp");
                CreateConnection instCon = new CreateConnection();
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                Connection cont = DriverManager.getConnection(instCon.getUrl() + instCon.getDatabase(), instCon.getUser(), instCon.getPassword());
                
                DataBaseDiscussionQueries inst = new DataBaseDiscussionQueries(cont);
                DataBaseInformationQueries users = new DataBaseInformationQueries(cont);
                
                
                UserInfo senderInfo = (UserInfo) request.getSession().getAttribute("person");
                //The time argument for chat info hasn't been handled and the dummy argument is used for now!!! 
                ChatInfo chatInfo = new ChatInfo(senderInfo.getEmail(), newMessage, "11:30");
                //out.println("<h1> Hello world</h1>");
                System.out.println(senderInfo.getEmail());
                inst.addChat(chatInfo);
                ArrayList contMessageList = inst.allMessages();
                ArrayList contUsers = users.allUsers();
                
                //I couldn't set an array for the recived argument from the jsp file. And for the time being strings are serving as a place holder
                //The optimal solution is to return an array for the caller tag in chat_room.jsp and build a div for the response.
                request.setAttribute("user_t",senderInfo.getFname());
                request.setAttribute("users",contUsers);
                request.setAttribute("sentMessage", contMessageList);
                cont.close();
                dispatcher.forward(request, response);
            }catch(Exception e){
                
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
