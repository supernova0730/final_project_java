<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="blog.do">Go to Website</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="list.do">List</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="add.do">Add</a>
            </li>
        </ul>
    </div>
    <div class="my-2 my-lg-0">
        <ul class="navbar-nav">
            <li class="nav-item mr-2">
                <a class="nav-link" href="#">Hello ${ sessionScope.user.username }</a>
            </li>
            <li class="nav-item mr-2">
                <a class="nav-link btn btn-outline-info" href="register.do">Register</a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-outline-info" href="logout.do">Logout</a>
            </li>
        </ul>
    </div>
</nav>