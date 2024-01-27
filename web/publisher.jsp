<%-- 
    Document   : publisher.jsp
    Created on : Jan 1, 2024, 11:12:31 PM
    Author     : quantap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Publish</title>
        <link rel="stylesheet" href="styles.css" />
        <style>
            body{
                background-color: black;
            }
            .PubPage{
                width: 90%;
                height: 800px;
                background: black;
                margin-top: 100px;
                
            }
            #title{
                width: 80%;
                height: 50px;
                font-size: 40px;
            }
            #textPubBox{
                width: 90%;
                height: 600px;
                background: white;
                margin-top: 100px;
                font-size: 35px;    
            }
            #pubButton{
                width: 10%;
                height: 50px;
                margin-left: 75%;
                font-size: 20px;
                
                
            }
            #pubButton:hover{
                color: white;
                background-color: black;
                border-radius: 40%;
            }
        </style>
    </head>
    <body>
        
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
            <div class="PubPage">
                <form action="PublishServlet">
                    <label for="publication" style="font-size: 40px">Title</label>
                    <input type="text" id="title" name="pubTitle"/>
                    <textarea id="textPubBox" name="pubText"></textarea>
                    <input type="submit" value="publish" id = "pubButton" />
                </form>
            </div>

        </center>   
        
    </body>
</html>
