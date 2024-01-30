<%-- 
    Document   : verificationPage
    Created on : Jan 30, 2024, 4:24:56 PM
    Author     : quantap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentication</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body class="verification_page">
        <div class="wrapper">
            <table>
                <tr><h1>WE have sent verifacation code. Check your email!</h1></tr>
                <tr>
                    <form action ="VerifyRegistration">
                        <input type="text" name="ver_code" placeholder="Verifcation Code"/>
                        <input type="submit" name="submit" />
                    </form>
                    <h3 name="error_message"></h3>
                </tr>
            </table>
        </div>
    </body>
</html>
