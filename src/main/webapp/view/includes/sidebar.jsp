<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="DAO.Model" %>
<%@ page import="DAO.CategoryDAO" %>
<%@ page import="DataBean.CategoryBean" %>
<%@ page import="org.genericdao.RollbackException" %>
<%@ page import="java.util.List" %>
<div class="sidebar">
    <div class="row">
        <div class="col-lg-12">
            <div class="sidebar-item search">
                <form id="search_form" name="gs" method="GET" action="#">
                    <input type="text" name="q" class="searchText" placeholder="type to search..." autocomplete="on">
                </form>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="sidebar-item recent-posts">
                <div class="sidebar-heading">
                    <h2>Recent Posts</h2>
                </div>
                <div class="content">
                    <ul>
                        <li><a href="post-details.html">
                            <h5>Vestibulum id turpis porttitor sapien facilisis scelerisque</h5>
                            <span>May 31, 2020</span>
                        </a></li>
                        <li><a href="post-details.html">
                            <h5>Suspendisse et metus nec libero ultrices varius eget in risus</h5>
                            <span>May 28, 2020</span>
                        </a></li>
                        <li><a href="post-details.html">
                            <h5>Swag hella echo park leggings, shaman cornhole ethical coloring</h5>
                            <span>May 14, 2020</span>
                        </a></li>
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
                            ServletContext context = request.getServletContext();
                            Model model = (Model) context.getAttribute("model");
                            CategoryDAO categoryDAO = model.getCategoryDAO();
                            List<CategoryBean> categories = categoryDAO.getAllCategories();
                        %>

                        <% for (CategoryBean category: categories) { %>
                            <li><a href="#">- <%= category.getTitle() %></a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>