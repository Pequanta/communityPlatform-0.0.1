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
        <link rel="stylesheet" type="text/css" href="styles.css" />
        <title>Sign In</title>
    </head>
    <body class="signin sign_page">
        <center>
            <div class="signing signin">
                    <%
                        String[] formEntries = {"Email","password"};
                        String[] formNames = {"email","password"};
                    %>
                    <form action="AuthenticateUser">
                        <h1>Community Platform EEEE</h1>
                        <table id="table">
                            <% 
                                for(int a = 0; a < formEntries.length;a++){
                                    if(formEntries[a] == "password"){
                            %>
                                        <tr>
                                            <td><label><%=formEntries[a] %></label></td>
                                            <td><input type="password" name=<%=formNames[a]%> /></td> 

                                        </tr>
                            <%
                                continue;
                                }
                            %>
                                    <tr>
                                        <td><label><%=formEntries[a] %></label></td>
                                        <td><input type="text" name=<%=formNames[a]%> /></td> 

                                    </tr>
                             <%
                                 }
                             %>
                            <tr><td><input type="submit" name="signin" value="signin"/></td></tr>
                        </table>
                        <a href="signup.jsp">Sign up</a>
                    </form>

            </div>
        </center>
    </body>
</html>
