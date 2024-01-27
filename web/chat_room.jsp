

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
              <div class="chat_box">
                  <div class="chat_display">
                      <div class="sent_m">
                          <%
                              ArrayList<String> updatedData = (ArrayList) request.getAttribute("sentMessage");
                              if(updatedData != null){
                                  for(int i = 0; i < updatedData.size();i++){
                                      %>
                                      <div class="messageDiv"><%=updatedData.get(i).split(",")[0]%> : <%=updatedData.get(i).split(",")[1]%></div></br>
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
