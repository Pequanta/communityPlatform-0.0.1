/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;
import databaseHandlers.DataBaseInformationQueries;
import dataContainers.UserInfo;
import databaseHandlers.CreateConnection;
import importantUtils.UserInputValidate;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
//import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author quantap
 */
public class RegisterUser extends HttpServlet {

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
            String userName = request.getParameter("uname"), 
                    userInstitute = request.getParameter("institute"),
                    userEmail = request.getParameter("email"),
                    userEducationLevel = request.getParameter("education_level"),
                    userPassword = request.getParameter("password");
            String[] userFullName = userName.split(" ");
            try{
                UserInfo userData = new UserInfo(userFullName[0], userFullName[1],userInstitute, userEmail, userPassword, Integer.parseInt(userEducationLevel));
                CreateConnection instCon = new CreateConnection();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection cont = DriverManager.getConnection(instCon.getUrl() + instCon.getDatabase(), instCon.getUser(), instCon.getPassword());
                DataBaseInformationQueries inst = new DataBaseInformationQueries(cont);
                
                //User credentials are analysed with the following logic;
                //First validation will be about input validation and the second will be about the users legitmacy for registration;
                //This include whether the user has already been registered or whether the user is student or professional
                
                
                //One problem seems to be hard to reach though
                //The question that "Who is authorized to have professional account ?" is not answered with this logic. 
                if(UserInputValidate.validEmail(userEmail) && UserInputValidate.validName(userName) && !inst.checkUserExist(userData)){
                    inst.addUser(userData);
                    out.println("<h1>Successfully signed up</h1>");
                    out.println("<a href=\"signin.jsp\"><h1>Signin</h1></a>");
                }else if(!UserInputValidate.validName(userName)){
                    out.println("<h1>Invalid Name</h1>");
                    out.println("<a href=\"signup.jsp\"><h1>TryAgain!</h1></a>");
                }else if(!UserInputValidate.validEmail(userEmail)){
                    out.println("<h1>Invalid Email</h1>");
                    out.println("<a href=\"signup.jsp\"><h1>TryAgain!</h1></a>");
                }else if(inst.checkUserExist(userData)){
                    out.println("<h1>User alread exists</h1>");
                    out.println("<a href=\"signin.jsp\"><h1>Sign in</h1></a>");
                }else{
                    out.println("<h1>Invalid Credentials</h1>");
                    out.println("<a href=\"signup.jsp\"><h1>TryAgain!</h1></a>");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
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

