<%--
  Created by IntelliJ IDEA.
  User: DELL 1
  Date: 30-09-2019
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>
        <div><a href="login.jsp">Logout</a></div>
        <h1>This is the page that can be accessed by both the admin and the normal users.</h1>
        <h3>Hi: ${username}</h3>

</body>
</html>
