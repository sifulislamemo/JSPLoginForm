<%-- 
    Document   : welcome
    Created on : Jan 23, 2022, 9:17:23 AM
    Author     : user
--%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <c:forEach items = "${users}" var = "user">
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                </c:forEach>
            </tr>
        </table>
    </body>
</html>
