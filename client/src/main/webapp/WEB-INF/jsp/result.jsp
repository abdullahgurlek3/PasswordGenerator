<%-- 
    Document   : index
    Created on : Aug 3, 2016, 21:52:55 PM
    Author     : Abdullah Gürlek
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Page</title>
    </head>
    <body>
        <h1>Password Generator Results</h1>
        ${newPasswordsString}
    </body>
</html>
