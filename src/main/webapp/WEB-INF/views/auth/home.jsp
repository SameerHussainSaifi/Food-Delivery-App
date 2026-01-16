<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.food.Model.Restaurant" %>
<%@ page import="java.util.List" %>

<%
    List<Restaurant> restaurantList =
        (List<Restaurant>) session.getAttribute("restaurantList");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>

    <!-- CSS -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/css/home.css">
</head>

<body>

<div class="container">

    <!-- User Profile -->
    <section class="card profile">
        <h2>User Profile</h2>
        <div class="profile-details">
            <p><strong>Name:</strong> ${user.userName}</p>
            <p><strong>Email:</strong> ${user.email}</p>
            <p><strong>Mobile:</strong> ${user.phone}</p>
        </div>
    </section>

    <!-- Restaurants -->
    <section class="card restaurants">
        <h2>Available Restaurants</h2>

        <div class="restaurant-grid">
            <%
                if (restaurantList != null && !restaurantList.isEmpty()) {
                    for (Restaurant r : restaurantList) {
            %>
                <div class="restaurant-card">
                    <h3><%= r.getName() %></h3>

                    <p><strong>ID:</strong> <%= r.getRestaurantId() %></p>
                    <p><strong>Cuisine:</strong> <%= r.getCuisineType() %></p>
                    <p><strong>Delivery:</strong> <%= r.getDeliveryTime() %> mins</p>
                    <p><strong>Rating:</strong> ⭐ <%= r.getRating() %></p>
                    <p class="status <%= r.getActive() ? "active" : "inactive" %>">
                        <%= r.getActive() ? "Open" : "Closed" %>
                    </p>
                    <p class="address"><%= r.getAddress() %></p>
                </div>
            <%
                    }
                } else {
            %>
                <p class="no-data">No restaurants available.</p>
            <%
                }
            %>
        </div>
    </section>

</div>

</body>
</html>
