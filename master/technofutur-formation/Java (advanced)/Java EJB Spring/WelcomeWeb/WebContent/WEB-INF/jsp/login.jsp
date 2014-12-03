<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="<%= request.getContextPath() %>/login.do" method="POST">
            <table>
                <tr>
                    <td colspan="2">Login</td>
                </tr>

                <tr>
                    <td>Login</td>
                    <td><input type="text" name="username" /></td>
                </tr>

                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" /></td>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="Login" align="middle" /></td>
                </tr>
            </table>
        </form>

        <p>
            <font color="red">
                <%Object errors = request.getAttribute("errors");
                            if (errors != null) {
                                out.print(errors.toString());
                            }
                %>
            </font>
        </p>
    </body>
</html>
