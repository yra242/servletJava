<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">My Application</a>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <button class="btn btn-light" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasMenu" aria-controls="offcanvasMenu">
            Open Menu
        </button>
    </div>
</nav>

<!-- Offcanvas Sidebar -->
<div class="offcanvas offcanvas-end bg-light" tabindex="-1" id="offcanvasMenu" aria-labelledby="offcanvasMenuLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasMenuLabel">Menu</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="cabinet.jsp">Cabinet</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" style="${sessionScope.displayStyle}" href="shoppingcart.jsp">shoppingcart</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about.jsp">About</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="contact.jsp">Contact</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">Logout</a>
            </li>
        </ul>
    </div>
</div>

<!-- Bootstrap JS (with Popper.js) -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
