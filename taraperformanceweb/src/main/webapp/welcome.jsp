<%--
  Created by IntelliJ IDEA.
  User: DELL 1
  Date: 26-09-2019
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome ${username}</title>
</head>
<body>
        <div>
            <a href=${"/login"}>Logout</a>
            <a href=${"/admin"}>Admin Page</a>
            <a href=${"/normaluser"}>User profile</a>

        </div>
        <h1>This is the Welcome page</h1>
        <h2>Hello ${username}</h2>

        <c:url value="/logout" var="logoutUrl" />
        <form id="logout" action="${logoutUrl}" method="post" >
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a href="javascript:document.getElementById('logout').submit()">Logout</a>
        </c:if>

</body>
</html>
