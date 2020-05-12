<%--
  Created by IntelliJ IDEA.
  User: DELL 1
  Date: 30-09-2019
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Hi ${username}</title>
</head>
<body>

    <div><a href="login.jsp">Logout</a></div>
    <h1>This is the admin page</h1>
    <h3>Admin Name : ${username}</h3>

</body>
</html>
