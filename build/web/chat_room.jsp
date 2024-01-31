

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
        <meta http-equiv="Cache-Control" content="no-store, no-cache, must-revalidate, max-age=0">
        <title>ChatRoom</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    
    <body class="chat_body">
        <jsp:include page="UserDisplayServlet" />
        <jsp:include page="MessageLoadServlet" />
        
        <center>
            <header class="header">
                <div class="logo"><img src="assets/logo.jpg" alt="logo"><h3>AAiT SECE community</h3></div>
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
            </header>
            <form action="SearchServlet">
                <input type="text" name="search_text" placeholder="search" class="searchButton input"/>
                <input type="submit" value="search" class="searchButton button"/>
            </form>
            <div class="chat_box">
                    <div class="sent_m">

                        <%
                            ArrayList<String> updatedData = (ArrayList) request.getAttribute("sentMessage");
                            if(updatedData != null){
                                for(int i = 0; i < updatedData.size();i++){
                                    %>
                                    <div><div class="messageDiv"><h6 id="user_name"><%=updatedData.get(i).split(",")[0]%> </h6><%=updatedData.get(i).split(",")[1]%></div><div><img src="assets/user.png" class="user_info" alt="user_img"/><!----></div></div></br>
                                    <%
                                    }
                            }

                        %>  
                    </div>

                <form action="SendMessageServlet">
                    <input style="font-size: 40px" type="text" name="message" class="message_box"/>
                    <input type="submit" name="send"  value="send" class="send_message"/>
                </form>
            </div>
            <div class="users_box">
                <label>Members</label>
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
