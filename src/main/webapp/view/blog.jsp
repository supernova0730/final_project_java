<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content="" />
    <meta name="author" content="" />
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&display=swap" rel="stylesheet"/>

    <title>Index</title>

    <link href="${ pageContext.request.contextPath }/view/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    <link rel="stylesheet" href="${ pageContext.request.contextPath }/view/assets/css/fontawesome.css" />
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/view/assets/css/templatemo-stand-blog.css"/>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/view/assets/css/owl.css" />
</head>
<body>
    <jsp:include page="includes/header.jsp" />

    <div class="main-banner header-text">
        <div class="container-fluid">
            <div class="owl-banner owl-carousel">
                <c:forEach var="article" items="${ requestScope.articles }">
                    <div class="item">
                        <img src="${ pageContext.request.contextPath }/image/${ article.articleBean.image }" alt="">
                        <div class="item-content">
                            <div class="main-content">
                                <div class="meta-category">
                                    <span>${ article.categoryName }</span>
                                </div>
                                <a href="detail.do?id=${ article.articleBean.id }"><h4>${ article.articleBean.title }</h4></a>
                                <ul class="post-info">
                                    <fmt:setLocale value="en_US"/>
                                    <li><a href="#"><fmt:formatDate pattern="MMMM d, y" value="${ article.articleBean.dateCreated }"/></a></li>
                                    <li><a href="#">${ article.numberOfComments } Comments</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

    <section class="blog-posts grid-system">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="all-blog-posts">
                        <div class="row">
                            <c:forEach var="article" items="${ requestScope.articles }">
                                <div class="col-lg-6">
                                    <div class="blog-post">
                                        <div class="blog-thumb">
                                            <img src="${ pageContext.request.contextPath }/image/${ article.articleBean.image }" alt="">
                                        </div>
                                        <div class="down-content">
                                            <span>${ article.categoryName }</span>
                                            <a href="detail.do?id=${ article.articleBean.id }"><h4>${ article.articleBean.title }</h4></a>
                                            <ul class="post-info">
                                                <li>
                                                    <fmt:setLocale value="en_US"/>
                                                    <a href="#">
                                                        <fmt:formatDate pattern="MMMM d, y" value="${ article.articleBean.dateCreated }"/>
                                                    </a>
                                                </li>
                                                <li><a href="#">${ article.numberOfComments } comments</a></li>
                                            </ul>
                                            <p>${ article.articleBean.minContent }</p>
                                            <div class="post-options">
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <ul class="post-tags">
                                                            <li><i class="fa fa-tags"></i></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
<%--                            <div class="col-lg-12">--%>
<%--                                <ul class="page-numbers">--%>
<%--                                    <li class="active"><a href="#">1</a></li>--%>
<%--                                    <li><a href="#">2</a></li>--%>
<%--                                    <li><a href="#">3</a></li>--%>
<%--                                    <li><a href="#"><i class="fa fa-angle-double-right"></i></a></li>--%>
<%--                                </ul>--%>
<%--                            </div>--%>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <jsp:include page="includes/sidebar.jsp" />
                </div>
            </div>
        </div>
    </section>

    <jsp:include page="includes/footer.jsp" />

    <script src="${ pageContext.request.contextPath }/view/vendor/jquery/jquery.min.js"></script>
    <script src="${ pageContext.request.contextPath }/view/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="${ pageContext.request.contextPath }/view/assets/js/custom.js"></script>
    <script src="${ pageContext.request.contextPath }/view/assets/js/owl.js"></script>
    <script src="${ pageContext.request.contextPath }/view/assets/js/slick.js"></script>
    <script src="${ pageContext.request.contextPath }/view/assets/js/isotope.js"></script>
    <script src="${ pageContext.request.contextPath }/view/assets/js/accordions.js"></script>

    <script language="text/Javascript">
        cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
        function clearField(t) {
            //declaring the array outside of the
            if (!cleared[t.id]) {
                // function makes it static and global
                cleared[t.id] = 1; // you could use true and false, but that's more typing
                t.value = ""; // with more chance of typos
                t.style.color = "#fff";
            }
        }
    </script>
</body>
</html>