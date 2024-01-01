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
        <jsp:include page="/PublicationStartPageServlet" />;
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
        </center>
        <div class="allPublications"><div>
        <div class="publicationPage">
            
            <% ArrayList contP = (ArrayList) request.getAttribute("publicationCont");
                if(contP != null){
                    for(int i = 0; i < contP.size(); i++){
                    %>
                    <div class="publicationEach"><%=contP.get(i)%></div>
                    <%
                }
                }
            %>
        </div>
        
        
    </body>
</html>
