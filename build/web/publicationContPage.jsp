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
        <form action="DisplayPublicationServlet">
            <div class="publicationPage">
                <% String content = (String) request.getAttribute("content");%>
                <% if(content!= null) {%> 
                                        <h1 name="text_H"><%=content%></h1>
                <% } %>
                
            </div>   
            <div class="allPublications">
                <%
                    ArrayList<String> publications = (ArrayList) request.getAttribute("allPublicationCont");
                    ArrayList<String> pubIds= new ArrayList<String>(); 
                    
                    if(publications != null){
                        for(int i = 0; i < publications.size();i++){
                            %>
                            <button type="submit" name="pubId" id="dispPub" value=<%=publications.get(i).split(",")[2]%>>
                                <h1><%=publications.get(i).split(",")[3]%></h1>
                                <h4 class="authorInfo"><%=publications.get(i).split(",")[0]%></h4>
                                <h4 class="authorInfo"><%=publications.get(i).split(",")[1]%></h4>
                            </button><br>
 
                            <%
                            }
                    }

                %> 
            </div>
        </form>

        
        
    </body>
</html>
