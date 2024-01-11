<%-- 
    Document   : signup
    Created on : Dec 20, 2023, 10:00:40 PM
    Author     : quantap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
        
    </head>
    <body class="signup sign_page">
        <%
            String[] formEntries = {"User Name", "Institute","Email", "Education Level", "password"};
            String[] formNames = {"uname", "institute", "email", "education_level","password"};
        %>
        <center>
            <div class="signing signup">
                    <form action="RegisterUser">
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
                                    if(formEntries[a] == "Education Level"){
                            %>
                                        <tr>
                                            <td><label><%=formEntries[a] %></label></td>
                                            <td><select name=<%=formEntries[a]%>>
                                                <optgroup label="Student">
                                                  <option value="student">0</option>
                                                </optgroup>
                                                <optgroup label="Professional">
                                                  <option value="professional">1</option>
                                                </optgroup>
                                                </select></td>

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
                            <tr><td><input type="submit" name="signup" value="signup"/></td></tr>
                        </table>
                        <a href="signin.jsp">Sign in</a>
                    </form>

            </div>
    </center>
    </body>
</html>
