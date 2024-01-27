<%-- 
    Document   : publication_page
    Created on : Dec 20, 2023, 10:01:30 PM
    Author     : quantap
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publication</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
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
            <form action="PublicationPageServlet">
                <input type="submit" name="publicationPage" value="Publicaiton Page" class="pubPageLinks"/>
            </form>
            <form action="PublishServlet">
                <input type="submit" name="publishPage" value="Publishing Page" class="pubPageLinks"/>
            </form>
        </center>
        
    </body>
</html>
