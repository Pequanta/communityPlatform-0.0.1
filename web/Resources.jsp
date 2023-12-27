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
            <header class="header">
                <nav>
                    <%
                        String[] links = {"home.jsp", "publication_page.jsp" , "chat_room.jsp", "Resources.jsp"};
                        String[] pageNames = {"Home", "Publication", "Discussion", "Resources"};
                        for(int j = 0; j < links.length;j++){
                    %>
                    <a href=<%=links[j]%>><%=pageNames[j] %></a>
                    <%
                        }
                    %>
                </nav>
            </header>
            
            <h1>Resource Page</h1>
        </center>
    </body>
</html>
