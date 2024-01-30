<%-- 
    Document   : home
    Created on : Dec 24, 2023, 8:21:13 AM
    Author     : quantap
--%>


<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body class="home_page">
        <center>  
            <header>
                <div class="logo"><img src="assets/logo.jpg" alt="logo"><h3>AAiT SECE community</h3></div>
                
                <%
                    if(request.getSession().getAttribute("person") == null){
                    %>
                        
                        <form action="LogOutServlet">
                            <button>Sign in</button></a>
                        </form>
                    <%
                    }else{
                        %>
                        <nav>
                            <ul class="nav_bar">
                              <%
                                  String[] links = {"home.jsp", "publicationContPage.jsp" , "chat_room.jsp", "Resources.jsp"};
                                  String[] pageNames = {"Home", "Publication", "Discussion", "Resources"};
                                  for(int j = 0; j < links.length;j++){
                              %>
                              <li><a href=<%=links[j]%>><%=pageNames[j] %></a><li>
                              <%
                                  }
                              %>
                          </ul>
                        </nav>
                        <form action="LogOutServlet">
                          <button>Log out</button></a>
                        </form>
                          <%
                    }
                %>
                
            </header>
            <div class="wrapper_for_p">
                <div class="pictureCont">
                    <img src="assets/sece.jpg" alt="sece_name" class="dispPictures" /> 
                </div>
                <h2>School of Electrical and Computer Engineering(AAiT/AAU)</h2>
                <div class="homePageParagraph">
                    Start and Early Needs for New Directions in Engineering EducationStarting from the earliest historical backgrounds, it can be said that in 46 years the Electrical 
                    Engineering (EE) programs of study of Institute of Technology (AAiT), AAU has grown and expanded from basic power and electronics engineering into five streams:

                                Electronic Communication Engineering
                                Power Engineering
                                Industrial Control Engineering
                                Computer Engineering
                                Microelectronics Engineering
                                Earliest EE Programs
                    The growth trends and pace in introducing streams of study (or focus areas) have been moving steadily but rather gradually in line with progresses in staff development
                    at senior and junior levels, as well as with the acquisitions of laboratory facilities in the AAiT, all mostly built with generous contributions of donor countries like
                    Israel (Faculty leadership from the technion in the 1960s) and Germany (new Faculty Building with laboratory facilities since 1969).
                </div>
                <div class="pictureCont">
                    <img src="assets/lab.png" alt="sece_name" class="dispPictures" />
                </div>
                
                <div class="homePageParagraph">
                    Excellence in teaching, research, and industry linkage/consultancy
                    Produce competent engineers in its core areas of study
                    Realization of this vision
                    Focus on specializations relevant to the need of the country
                    Runs both undergraduate & graduate (Masters, PhD) programs
                </div>
                <div class="pictureCont">
                    <img src="assets/innovate.png" alt="sece_name" class="dispPictures" /> 
                </div>
                
                <div class="homePageParagraph">
                    Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. 
                    At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor 
                    sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. 
                    At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
                </div>
                <div class="pictureCont">
                    <img src="assets/exel.png" alt="sece_name" class="dispPictures" />
                </div>
                
                
            </div>
        </center>
    </body>
</html>
