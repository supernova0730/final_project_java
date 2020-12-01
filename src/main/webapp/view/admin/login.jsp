<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/view/admin/css/style.css">
    <title>Admin Panel</title>
</head>
<body>
    <div class="login-form">
        <form action="login.do" method="POST">
            <h2 class="text-center">Welcome</h2>

            <c:if test="${ requestScope.errors != null }">
                <ul class="errors text-danger">
                    <c:forEach var="error" items="${ requestScope.errors }" >
                        <li>${ error }</li>
                    </c:forEach>
                </ul>
            </c:if>

            <div class="form-group">
                <input type="text" name="username" class="form-control" placeholder="Username" required="required">
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="Password" required="required">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Sign in</button>
            </div>
        </form>
    </div>
</body>
</html>
