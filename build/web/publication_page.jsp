<%-- 
    Document   : publication_page
    Created on : Dec 20, 2023, 10:01:30 PM
    Author     : quantap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jservlets.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publication</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <center>
            <header class="header">
                <nav>
                    <%
                        String[] links = {"publication_page.jsp" , "chat_room.jsp", "Resources.jsp"};
                        String[] pageNames = {"Publication", "Discussion", "Resources"};
                        for(int j = 0; j < links.length;j++){
                    %>
                    <a href=<%=links[j]%>><%=pageNames[j] %></a>
                    <%
                        }
                    %>
                </nav>
            </header>
            <form action="PublicationPageServlet">
                <input type="submit" name="publicationPage" value="Publicaiton Page" />
            </form>
            <form action="PublishServlet">
                <input type="submit" name="publishPage" value="Publishing Page" />
            </form>
        </center>
        
    </body>
</html>
