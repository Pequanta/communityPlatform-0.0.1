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
                        String[] formNames = {"email","password"};
                    %>
                    <form action="AuthenticateUser">
                        
                        <table id="table">
                            <tr>
                                <td><input type="text" name=<%=formNames[0]%> placeholder="Email"/></td> 

                            </tr>
                            <tr>
                                <td><input type="password" name=<%=formNames[1]%> placeholder="Password" /></td> 

                            </tr>
                             <tr><td><button type="submit" name="signin" value="signin">Sign in</button></td></tr>
                             
                        </table>
                                <h1 class ="error_message"></h1>
                        <h1 class="note_labels">Don't have an account? <a href="signup.jsp">Sign up</a></h1>
                    </form>

            </div>
        </center>
    </body>
</html>
