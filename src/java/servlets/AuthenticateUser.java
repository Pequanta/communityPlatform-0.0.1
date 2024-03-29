/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;
import databaseHandlers.DataBaseInformationQueries;
import dataContainers.UserInfo;
import databaseHandlers.CreateConnection;
import importantUtils.UserInputValidate;
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
//import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author quantap
 */
public class AuthenticateUser extends HttpServlet {

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
            throws ServletException, IOException{
            PrintWriter out = response.getWriter();
            String userEmail = request.getParameter("email"),
                    userPassword = request.getParameter("password");
            
            try{
                
                CreateConnection instCon = new CreateConnection();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection cont = DriverManager.getConnection(instCon.getUrl() + instCon.getDatabase(), instCon.getUser(), instCon.getPassword());
                DataBaseInformationQueries inst = new DataBaseInformationQueries(cont);
                UserInfo userData = inst.getUserInfoByEmail(userEmail);
                RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
                
                if(userData == null){
                    request.setAttribute("error_message","Email doesn't exist");
                    dispatcher.forward(request, response);
                }else if(userEmail.equals("")){
                    request.setAttribute("error_message", "Please Insert credentials! Try again");
                    dispatcher.forward(request, response);
                }else if(UserInputValidate.validEmail(userData.getEmail()) && userData.getPassword().equals(userPassword)){
                    HttpSession session = request.getSession(true);
                    session.setAttribute("connection", cont);
                    session.setAttribute("person" , userData);
                    response.sendRedirect("home.jsp");
                }else if(!userData.getPassword().equals(userPassword)){
                    request.setAttribute("error_message", "Invalid Password! Try again");
                    dispatcher.forward(request, response);
                }else{
                    request.setAttribute("error_message","Email doesn't exist");
                    dispatcher.forward(request, response);
                }
                cont.close();
                
                
                
            }catch(Exception e){
                out.println("<h1>" + e.getMessage()+"</h1>");
                e.printStackTrace();
            }
            
//            try{
//                
//            }catch(Exception e){
//            }
//            
    }
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

