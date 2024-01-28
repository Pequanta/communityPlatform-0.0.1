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
            <h1>Community Platform EEEE</h1>
            <div class="wrapper">
                    <form action="RegisterUser">
                        
                        <table id="table">
                            <% 
                                for(int a = 0; a < formEntries.length;a++){
                                    if(formEntries[a] == "password"){
                            %>
                                        <tr>
                                            <td><input type="password" name=<%=formNames[a]%> placeholder="Password"/></td> 

                                        </tr>
                            <%
                                    continue;
                                }
                                    if(formEntries[a] == "Education Level"){
                                        System.out.println(formEntries[a]);
                                        System.out.println(formNames[a]);
                            %>
                                        <tr>
                                            <td><label style="font-size: 40px; margin-left: 10px"><%=formEntries[a] %></label></td>
                                            <td><select style="margin-left: -400px; width: 100px; height: 40px; border-radius: 10px; font-size: 30px" name=<%=formNames[a]%> />
                                                <optgroup label="Student">
                                                  <option value=0>0</option>
                                                </optgroup>
                                                <optgroup label="Professional">
                                                  <option value=1>1</option>
                                                </optgroup>
                                                </select></td>
 
                                        </tr>
                            <%
                                    continue;
                                }
                            %>
                            
                                    <tr>
                                        <td><input type="text" name=<%=formNames[a]%> placeholder=<%=formEntries[a] %> /></td> 

                                    </tr>
                             <%
                                 }
                             %>
                             <tr><td><button type="submit" name="signup" value="signup">Sign up</button></td></tr>
                        </table>
                             <h1 class="note_labels">Already have an account? <a href="signin.jsp">Sign in</a></h1>
                    </form>

            </div>
    </center>
    </body>
</html>
