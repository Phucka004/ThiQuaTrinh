<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="iostar.controllers.LoginController"%>
<%
String email = "";
Cookie[] cookies = request.getCookies();
Boolean remember = (Boolean) request.getAttribute("remember");
if ((remember != null && remember == false)) {
    return;
} else if (cookies != null) {
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("email")) {
            email = cookie.getValue();
            break;
        }
    }
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h3 class="text-center mb-4">Login</h3>
            <form action="${pageContext.request.contextPath}/login" method="post" class="border p-4 shadow-sm rounded">
                <c:if test="${alert != null}">
                    <div class="alert alert-danger" role="alert">
                        ${alert}
                    </div>
                </c:if>

                <div class="form-group">
                    <label for="email">Email <span class="text-danger">*</span></label>
                    <input type="email" class="form-control" id="email" name="email" value="<%=email%>" required>
                </div>

                <div class="form-group">
                    <label for="password">Password <span class="text-danger">*</span></label>
                    <input type="password" class="form-control" id="password" name="password" required>
                </div>

                <div class="form-check mb-3">
                    <input class="form-check-input" type="checkbox" id="remember" name="remember"
                           <%= (email != null && !email.isEmpty()) ? "checked" : "" %>>
                    <label class="form-check-label" for="remember">Remember me</label>
                </div>

                <div class="d-flex justify-content-between align-items-center mb-3">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
