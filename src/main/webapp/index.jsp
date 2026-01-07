<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>QuickDish</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/index.css">
</head>

<body>

<!-- Header -->
<header class="header">
    <nav class="navbar container">
        <h1 class="logo">QuickDish</h1>

        <ul class="nav-links">
            <li><a href="${pageContext.request.contextPath}/login" class="btn">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/login" class="btn">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/registerpage" class="btn">Register</a></li>
        </ul>
    </nav>
</header>

<!-- Hero Section with Background Image -->
<main class="hero"
      style="background-image: url('${pageContext.request.contextPath}/assets/images/banner5.webp');">
    <div class="hero-overlay">
        <h2>Welcome to QuickDish Food Delivery</h2>
        <p>Delicious food delivered fast to your doorstep.</p>

        <div class="hero-buttons">
            <a href="#" class="btn primary">Order Now</a>
            <a href="#" class="btn secondary">Explore Menu</a>
        </div>
    </div>
</main>

<!-- Footer -->
<footer class="footer">
    <p>© 2024 QuickDish Food Delivery. All rights reserved.</p>
</footer>

</body>
</html>
