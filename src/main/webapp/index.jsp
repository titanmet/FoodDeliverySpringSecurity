<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="static/css/main.css"/>
    <title>Food Delivery</title>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<header>
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="col-4">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <sec:authorize access="!isAuthenticated()">
                            <a class="text-white nav-link" tabindex="-1" href="/FoodDeliverySpringSecurity_war/login">Log In</a>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <a class="text-white nav-link" href="/FoodDeliverySpringSecurity_war/logout" th:href="@{/logout}">Log Out</a>
                        </sec:authorize>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-4">
            <h1 class="text-white text-center"><a class="main-logo-link" href="/FoodDeliverySpringSecurity_war/" th:href="@{/DeliciousFoodDelivery_war/}">Food Delivery</a></h1>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <div class="col-4 d-flex justify-content-end">
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>
<body>
<div class="row m-0 p-0">
    <div class="col-6 left-column m-auto">
        <img id="img_col" src="static/images/main_background_food.jpg">
    </div>
    <div class="col-6 right_column m-auto">
        <h1 class="display-3 text-center">The best choise ever!</h1>
        <p class="text-center font-italic">Enjoy of food or choose the best opportunity for earning. Delicious Food
            Delivery allows you to excite by the best dishes from your favourite restaurants, to get a job of courier or
            to get online order platform for restaurants.</p>
    </div>
</div>
</body>
</html>

