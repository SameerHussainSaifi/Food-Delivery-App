<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/assets/css/register.css">

</head>
<body>
<div id="container">
      <form action="${pageContext.request.contextPath}/login" method="post">

        <div>
          <div>
            <label for="email" class="label" >EmailID:</label>
          </div>
          <div >
            <input type="text" id="email" name="email" class="field"/>
          </div>
        </div>
        <div>
          <div>
            <label for="password" class="label">Password:</label>
          </div>
          <div >
          <input type="password" id="password"  name="password" class="field"/>
          </div>
        </div>

        <div id="button-container">
          <button class="label" id="button" class="field">Login</button>
        </div>
      </form>
    </div>
</body>
</html>