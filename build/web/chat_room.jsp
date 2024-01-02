

<%-- 
    Document   : main
    Created on : Dec 20, 2023, 2:31:34 AM
    Author     : quantap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChatRoom</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
        
    </head>
    
    <body class="chat_body">
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
            
            <h1>Chat Room</h1>
            <div class="chat_box">
                <div class="chat_display">
                    <div class="sent_m">
                        <%
                            ArrayList<String> updatedData = (ArrayList) request.getAttribute("sentMessage");
                            String name = (String) request.getAttribute("user_t");
                            if(updatedData != null){
                                for(int i = 0; i < updatedData.size();i++){
                                    %>
                                    <div class="messageDiv"><%=name%>: <%=updatedData.get(i)%></div></br>
                                    <%
                                    }
                            }
                            
                        %>  
                    </div>
                </div>
                <form action="SendMessageServlet">
                    <input type="text" name="message" class="message_box"/>
                    <input type="submit" name="send"  value="send" class="send_message"/>
                </form>
            </div>
            <div class="users_box">
                <label>Users</label>
                <%
                            ArrayList<String> allUsers = (ArrayList) request.getAttribute("users");
                            if(allUsers != null){
                                for(int j = 0; j < allUsers.size();j++){
                                    %>
                                    <div class="userDiv"><%= allUsers.get(j) %></div>
                                    <%
                                    }
                            }
                            
                %>  
            </div>
      </center>
    </body>
</html>
