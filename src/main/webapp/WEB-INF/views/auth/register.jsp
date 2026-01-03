<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/register.css">

</head>
<body>
<div id="container">
      <form action="registeruser" method="POST">
        <div>
          <div>
            <label for="username" class="label">Username:</label>
          </div>
          <div>
            <input type="text" id="username" name="username" class="field" required/>
          </div>
        </div>
        
        <div>
          <div>
            <div>
              <label for="email" class="label">Email:</label>
            </div>
            <div >
             <input type="email" id="email" name="email" class="field" required/> 
            </div>
          </div>
        </div>
         <div>
            <label for="address" class="label">Address</label>
            <input type="text" id="address" class="field">
         </div>
         <div>
            <label for="phone" class="label">Phone no. :</label>
            <input type="text" id="phone" class="field">
         </div>
        <div>
          <div>
            <label for="password" class="label">Password:</label>
          </div>
          <div>
            <input
              type="password"
              id="password"
              ,
              name="password"
              class="field"
           required />
          </div>
        </div>
         <div>
          <div><label for="role" class="label">Role:</label></div>
          <select name="role" id="role" class="field">
            <option value="customer">Customer</option>
            <option value="restaurantAgent">Restaurant Agent</option>
            <option value="deliveryAgent">Delivery Agent</option>
          </select>
         </div>
        <div id="button-container">
          <button class="label" id="button" class="field">Login</button>
        </div>
      </form>
    </div>
</body>
</html>