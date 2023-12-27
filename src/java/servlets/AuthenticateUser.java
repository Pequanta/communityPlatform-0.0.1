/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;
import databaseHandlers.DataBaseInformationQueries;
import dataContainers.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
            throws ServletException, IOException {
           DataBaseInformationQueries dataQuery = new DataBaseInformationQueries();
           PrintWriter out = response.getWriter();
            String[] name = request.getParameter("uname").split(" ");
            String userName =name[0],
                    lastName = name[0],
                    email = request.getParameter("email"),
                    institute = request.getParameter("institute"),
                    password = request.getParameter("password");
            int education_level = Integer.parseInt(request.getParameter("education_level"));
            UserInfo userData = new UserInfo(userName, lastName, institute, email, password,  education_level);
            UserInfo contInfo = dataQuery.userInfo(email);
            out.println("<h1>" + userData.getFname() + "</h1>");
            out.println("<h1>" + userData.getLname() + "</h1>");
            out.println("<h1>" + userData.getEmail() + "</h1>");
            out.println("<h1>" + userData.getInstitute() + "</h1>");
            out.println("<h1>" + userData.getPassword() + "</h1>");
            try{
                out.println("<h1>" + dataQuery.userInfo("Penielyohannes6@gmail.com") + "</h1>");
            }catch(Exception e){
                out.println("<h1>faield</h1>");
                e.printStackTrace();
            }
            
           try{
               if(dataQuery.con.isClosed()){
                    out.println("____" + contInfo.getEmail());
                    out.println("<h1>" + userData.getFname() + "</h1>");
                    out.println("<h1>" + userData.getLname() + "</h1>");
                    out.println("<h1>" + userData.getEmail() + "</h1>");
                    out.println("<h1>" + userData.getInstitute() + "</h1>");
                    out.println("<h1>" + userData.getPassword() + "</h1>");
                    out.println("<h1> -----------------------------</h1>");
                    out.println("<h1>" +contInfo.getFname() + "</h1>");
                    out.println("<h1>" + contInfo.getLname() + "</h1>");
                    out.println("<h1>" + contInfo.getEmail() + "</h1>");
                    out.println("<h1>" + contInfo.getInstitute() + "</h1>");
                    out.println("<h1>" + contInfo.getPassword() + "</h1>");
                    if(userData.getPassword().equals(dataQuery.userInfo(userData.getEmail()).getPassword())){
                        response.sendRedirect("home.jsp");
                    }
                }
            }catch(Exception e){
                out.println("<h1 hey there</h1>");
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

