<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualização dos dados</title>
    </head>
    <body>
        <h1>Visualização dos dados</h1>
        <a href="front"><button>VISUALIZAR</button></a>
        <br><br>
        <table border="1" style="    border-collapse: collapse;">
            <c:forEach var="linha" items="${dados}">
                <tr>
                    <c:forEach var="dado" items="${linha}">
                        <td align="center" style="padding:10px;">${dado}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
