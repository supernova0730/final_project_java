<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Admin Panel</title>
</head>

<body>
<jsp:include page="includes/header.jsp" />

<div class="container pt-5">
    <div class="row">
        <div class="col">
            <div class="row mb-5">
                <div class="col-6">
                    <h2 class="mb-3">Category Table</h2>
                    <table class="table table-sm table-bordered table-striped table-dark">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">id</th>
                            <th scope="col">Title</th>
                            <th scope="col" class="text-center">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="category" items="${ requestScope.categories }" varStatus="status">
                            <tr>
                                <th scope="row">${ status.count }</th>
                                <th scope="row">${ category.id }</th>
                                <td>${ category.title }</td>
                                <td class="text-center">
                                    <a href="deleteCategory.do?id=${ category.id }" class="btn btn-sm btn-danger">Remove</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row mb-5">
                <div class="col">
                    <h2 class="mb-3">Article Table</h2>
                    <table class="table table-bordered table-striped table-dark">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">id</th>
                            <th scope="col">Title</th>
                            <th scope="col">Category ID</th>
                            <th scope="col" class="text-center">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="article" items="${ requestScope.articles }" varStatus="status">
                            <tr>
                                <th scope="row">${ status.count }</th>
                                <th scope="row">${ article.id }</th>
                                <td><a href="detail.do?id=${ article.id }">${ article.title }</a></td>
                                <td>${ article.categoryId }</td>
                                <td class="text-center">
                                    <a href="deleteArticle.do?id=${ article.id }" class="btn btn-sm btn-danger">Remove</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row mb-5">
                <div class="col">
                    <h2 class="mb-3">Comment Table</h2>
                    <table class="table table-bordered table-striped table-dark">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">id</th>
                            <th scope="col">Author Name</th>
                            <th scope="col">Content</th>
                            <th scope="col">Article ID</th>
                            <th scope="col" class="text-center">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="comment" items="${ requestScope.comments }" varStatus="status">
                            <tr>
                                <th scope="row">${ status.count }</th>
                                <th scope="row">${ comment.id }</th>
                                <td>${ comment.authorName }</td>
                                <td>
                                    <p>${ comment.content }</p>
                                </td>
                                <td>${ comment.articleId }</td>
                                <td class="text-center">
                                    <a href="deleteComment.do?id=${ comment.id }" class="btn btn-sm btn-danger">Remove</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="row mb-5">
                <div class="col">
                    <h2 class="mb-3">Admin Table</h2>
                    <table class="table table-bordered table-striped table-dark">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">id</th>
                            <th scope="col">Username</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${ requestScope.users }" varStatus="status">
                            <tr>
                                <th scope="row">${ status.count }</th>
                                <th scope="row">${ user.id }</th>
                                <td>${ user.username }</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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