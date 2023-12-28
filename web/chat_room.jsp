

<%-- 
    Document   : main
    Created on : Dec 20, 2023, 2:31:34 AM
    Author     : quantap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            
            <h1>Chat Room</h1>
            <div class="chat_box">
                <div class="chat_display">
                    <div class="sent_m">
                        <%
                            String updatedData = (String) request.getAttribute("sentMessage");
                            out.print(updatedData);                        
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
                    // Assuming you have a list of labels or an array
                    String[] users = {"user1", "user2", "user3", "user4","user5"};

                    // Loop through the labels and generate HTML
                    for (int i = 0; i < 100;i++) {
                %>
                        <div class="user_disp"><%= users[i % users.length] %></div>
                <%
                    }
                %>
            </div>
      </center>
    </body>
</html>
