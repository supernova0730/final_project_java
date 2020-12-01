<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="">
    <nav class="navbar navbar-expand-lg">
        <div class="container">
            <a class="navbar-brand" href="/blog.do"><h2>Blog<em>.</em></h2></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <c:set var="uri" value="${ requestScope['javax.servlet.forward.request_uri'] }" scope="request" />

                    <li class="nav-item <c:if test='${ requestScope.uri == "/blog.do" }'>active</c:if>">
                        <a class="nav-link" href="/blog.do">Blog</a>
                    </li>
                    <li class="nav-item <c:if test='${ requestScope.uri == "/about.do" }'>active</c:if>">
                        <a class="nav-link" href="/about.do">About Us</a>
                    </li>
                    <li class="nav-item <c:if test='${ requestScope.uri == "/contact.do" }'>active</c:if>">
                        <a class="nav-link" href="/contact.do">Contact Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login.do">Admin Page</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>