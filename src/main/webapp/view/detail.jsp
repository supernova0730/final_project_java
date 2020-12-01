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

    <div class="heading-page header-text">
        <section class="page-heading">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="text-content">
                            <h4>${ requestScope.category.title }</h4>
                            <h2>${ requestScope.article.title }</h2>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <section class="blog-posts grid-system">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="all-blog-posts">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="blog-post">
                                    <div class="blog-thumb">
                                        <img src="${ pageContext.request.contextPath }/image/${ requestScope.article.image }" alt="">
                                    </div>
                                    <div class="down-content">
                                        <span>${ requestScope.category.title }</span>
                                        <a href="post-details.html"><h4>${ requestScope.article.title }</h4></a>
                                        <ul class="post-info">
                                            <fmt:setLocale value="en_US"/>
                                            <li>
                                                <a href="#">
                                                    <fmt:formatDate pattern="MMMM d, y" value="${ requestScope.article.dateCreated }"/>
                                                </a>
                                            </li>
                                            <li><a href="#">${ requestScope.comments.size() } Comments</a></li>
                                        </ul>
                                        <p>${ requestScope.article.content }</p>
                                        <div class="post-options">
                                            <div class="row">
                                                <div class="col-6">
                                                    <ul class="post-tags">
                                                        <li><i class="fa fa-tags"></i></li>
                                                    </ul>
                                                </div>
                                                <div class="col-6">
                                                    <ul class="post-share">
                                                        <li><i class="fa fa-share-alt"></i></li>
                                                        <li><a href="#">Facebook</a>,</li>
                                                        <li><a href="#"> Twitter</a></li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="sidebar-item comments">
                                    <div class="sidebar-heading">
                                        <h2>${ requestScope.comments.size() } comments</h2>
                                    </div>
                                    <div class="content">
                                        <ul>
                                            <c:forEach var="comment" items="${ requestScope.comments }" >
                                                <li>
                                                    <div class="author-thumb">
                                                        <img src="${ pageContext.request.contextPath }/view/assets/images/man.png" alt="">
                                                    </div>
                                                    <div class="right-content">
                                                        <fmt:setLocale value="en_US"/>
                                                        <h4>${ comment.authorName }
                                                            <span>
                                                                <fmt:formatDate pattern="MMMM d, y" value="${ comment.dateCreated }"/>
                                                            </span>
                                                        </h4>
                                                        <p>${ comment.content }</p>
                                                    </div>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="sidebar-item submit-comment">
                                    <div class="sidebar-heading">
                                        <h2>Your comment</h2>
                                    </div>
                                    <div class="content">
                                        <form id="comment" action="comment.do" method="post">
                                            <div class="row">
                                                <input type="hidden" name="articleId" value="${ requestScope.article.id }">
                                                <div class="col-md-6 col-sm-12">
                                                    <fieldset>
                                                        <input name="authorName" type="text" id="name" placeholder="Your name" required="">
                                                    </fieldset>
                                                </div>
                                                <div class="col-md-6 col-sm-12">
                                                    <fieldset>
                                                        <input name="email" type="text" id="email" placeholder="Your email" required="">
                                                    </fieldset>
                                                </div>
                                                <div class="col-lg-12">
                                                    <fieldset>
                                                        <textarea name="content" rows="6" id="message" placeholder="Type your comment" required=""></textarea>
                                                    </fieldset>
                                                </div>
                                                <div class="col-lg-12">
                                                    <fieldset>
                                                        <button type="submit" id="form-submit" class="main-button">Submit</button>
                                                    </fieldset>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
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
