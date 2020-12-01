<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Document</title>
</head>

<body>
<jsp:include page="includes/header.jsp" />

<div class="container pt-5">
    <div class="row">
        <div class="col-6">
            <h2>Register new admin</h2>

            <c:if test="${ requestScope.errors != null }">
                <ul class="errors text-danger">
                    <c:forEach var="error" items="${ requestScope.errors }" >
                        <li>${ error }</li>
                    </c:forEach>
                </ul>
            </c:if>

            <form action="register.do" method="POST">
                <div class="form-group">
                    <label>Username: </label>
                    <input type="text" name="username" class="form-control" placeholder="Enter username" required>
                </div>
                <div class="form-group">
                    <label>Password: </label>
                    <input type="password" name="password1" class="form-control" placeholder="Enter password" required>
                </div>
                <div class="form-group">
                    <label>Confirm Password: </label>
                    <input type="password" name="password2" class="form-control" placeholder="Confirm password" required>
                </div>
                <button type="submit" class="btn btn-primary">Register</button>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>
</body>

</html>