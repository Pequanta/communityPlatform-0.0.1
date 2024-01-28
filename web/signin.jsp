<%-- 
    Document   : signin
    Created on : Dec 20, 2023, 10:00:49 PM
    Author     : quantap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles.css" />
        <title>Sign In</title>
    </head>
    <body class="sign_page">
        <center>
            <h1>Community Platform EEEE</h1>
            <div class="wrapper">
                    <%
                        String[] formEntries = {"Email","password"};
                        String[] formNames = {"email","password"};
                    %>
                    <form action="AuthenticateUser">
                        
                        <table id="table">
                            <% 
                                for(int a = 0; a < formEntries.length;a++){
                                    if(formEntries[a] == "password"){
                            %>
                                        <tr>
                                            <td><input type="password" name=<%=formNames[a]%> placeholder="password" /></td> 

                                        </tr>
                            <%
                                continue;
                                }
                            %>
                                    <tr>
                                        <td><input type="text" name=<%=formNames[a]%> placeholder="Email"/></td> 

                                    </tr>
                             <%
                                 }
                             %>
                             <tr><td><button type="submit" name="signin" value="signin">Sign in</button></td></tr>
                             
                        </table>
                        <h1 class="note_labels">Don't have an account? <a href="signup.jsp">Sign up</a></h1>
                    </form>

            </div>
        </center>
    </body>
</html>
