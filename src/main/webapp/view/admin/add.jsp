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
        <div class="col">
            <div class="row mb-5">
                <div class="col-6">
                    <h2>Add Category</h2>
                    <form action="addCategory.do" method="POST">
                        <div class="form-group">
                            <label>Title: </label>
                            <input type="text" name="title" class="form-control" placeholder="Enter category title" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </div>
            <div class="row mb-5">
                <div class="col-6">
                    <h2>Add Article</h2>
                    <form action="addArticle.do" method="POST" enctype="multipart/form-data">
                        <div class="form-group">
                            <label>Title: </label>
                            <input type="text" name="title" class="form-control" placeholder="Enter category title" required>
                        </div>
                        <div class="form-group">
                            <label>Minimal content:</label>
                            <textarea name="minContent" class="form-control" rows="3" required></textarea>
                        </div>
                        <div class="form-group">
                            <label>Content:</label>
                            <textarea name="content" class="form-control" rows="5" placeholder="Enter article content" required></textarea>
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="inputGroupSelect01">Category</label>
                            </div>
                            <select class="custom-select" name="categoryId" id="inputGroupSelect01">
                                <c:forEach var="category" items="${ requestScope.categories }" >--%>
                                    <option value="${ category.id }">${ category.title }</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Image:</label>
                            <input type="file" name="image" class="form-control-file" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </div>
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