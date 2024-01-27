<%-- 
    Document   : Resources
    Created on : Dec 24, 2023, 8:26:52 AM
    Author     : quantap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resources</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body class="resource_body">
        <center>
            <header>
                  <img class="logo" src="logo.jpg" alt="logo"> 
                  <nav>
                      <ul class="nav_bar">
                        <%
                            String[] links = {"publication_page.jsp" , "chat_room.jsp", "Resources.jsp"};
                            String[] pageNames = {"Publication", "Discussion", "Resources"};
                            for(int j = 0; j < links.length;j++){
                        %>
                        <li><a href=<%=links[j]%>><%=pageNames[j] %></a><li>
                        <%
                            }
                        %>
                    </ul>
                  </nav>
                  <a class="about_link" href="#"><button>About</button></a>
              </header>
                <div class="resourcePage">
                    <div class="universityWebsites">
                        <ul id="sites">
                            <li><a href="http://www.aait.edu.et/">AAiT main</a></li>
                            <li><a href="http://www.aau.edu.et/">AAU main</a></li>
                            <li><a href="https://www.facebook.com/sece.aait">AAiT@facebook</a></li>
                        </ul>
                    </div>
                    <div class="universityWebsites">
                    </div>
                </div>
        </center>
    </body>
</html>
