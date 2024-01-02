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
        </center>
        <div class="publicationPage">
            <h1 name="text_H"> Place holder</h1>
        </div>   
        <div class="allPublications">
            <%
                            ArrayList<String> publications = (ArrayList) request.getAttribute("allPublicationCont");
                            if(publications != null){
                                for(int i = 0; i < publications.size();i++){
                                    %>
                                        <form action="DisplayPublicationServlet">
                                            <input type="submit" name=<%=publications.get(i)%> value=<%=publications.get(i)%> class="titles" />
                                        </form>
                                    <%
                                    }
                            }else{
                                %>
                                <h1>Check here</h1>
                                <%
                            }
                            
                        %> 
        </div>
        
        
        
    </body>
</html>
