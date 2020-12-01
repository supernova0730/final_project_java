<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="DAO.Model" %>
<%@ page import="DAO.CategoryDAO" %>
<%@ page import="DataBean.CategoryBean" %>
<%@ page import="java.util.List" %>
<%@ page import="DataBean.ArticleBean" %>
<%@ page import="DAO.ArticleDAO" %>
<div class="sidebar">
    <div class="row">
        <div class="col-lg-12">
            <div class="sidebar-item search">
                <form id="search_form" name="gs" method="GET" action="search.do">
                    <input type="text" name="q" class="searchText" placeholder="type to search..." autocomplete="on">
                </form>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="sidebar-item recent-posts">
                <div class="sidebar-heading">
                    <h2>Last Posts</h2>
                </div>
                <div class="content">
                    <ul>
                        <%
                            ServletContext context = request.getServletContext();
                            Model model = (Model) context.getAttribute("model");
                            ArticleDAO articleDAO = model.getArticleDAO();
                            List<ArticleBean> lastArticles = articleDAO.getLastArticles(3);
                        %>

                        <% for (ArticleBean article: lastArticles) { %>
                            <li>
                                <a href="detail.do?id=<%= article.getId() %>">
                                <h5><%= article.getTitle() %></h5>
                                <fmt:setLocale value="en_US"/>
                                <span><fmt:formatDate pattern="MMMM d, y" value="<%= article.getDateCreated() %>"/></span>
                                </a>
                            </li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="sidebar-item categories">
                <div class="sidebar-heading">
                    <h2>Categories</h2>
                </div>
                <div class="content">
                    <ul>
                        <%
                            CategoryDAO categoryDAO = model.getCategoryDAO();
                            List<CategoryBean> categories = categoryDAO.getAllCategories();
                        %>

                        <% for (CategoryBean category: categories) { %>
                            <li><a href="category.do?categoryId=<%= category.getId() %>">- <%= category.getTitle() %></a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>