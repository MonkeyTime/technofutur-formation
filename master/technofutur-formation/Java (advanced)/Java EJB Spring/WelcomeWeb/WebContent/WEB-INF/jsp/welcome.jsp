<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="be.wavenet.domain.User" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Bienvenue :
        <%
                    User user = (User) session.getAttribute("user");

                    if (user != null) {
                        out.print(user.getLogin());
                    } else {
                        out.print("unknown");
                    }
        %>
        <br>
        <a href="<%= request.getContextPath() %>/logout.do">[logout]</a>
    </body>
</html>
