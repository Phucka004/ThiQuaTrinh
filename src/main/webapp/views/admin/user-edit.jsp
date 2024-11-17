<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chỉnh sửa User</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Chỉnh sửa User</h2>
    
    <form action="${pageContext.request.contextPath}/admin/user/update" method="post">
        <!-- ID -->
        <div class="form-group">
            <label for="id">User ID</label>
            <input type="text" class="form-control" id="id" name="id" value="${user.id}" readonly>
        </div>

        <!-- Email -->
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
        </div>

        <!-- Full Name -->
        <div class="form-group">
            <label for="fullname">Full Name</label>
            <input type="text" class="form-control" id="fullname" name="fullname" value="${user.fullname}" required>
        </div>

        <!-- Phone -->
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" class="form-control" id="phone" name="phone" value="${user.phone}" required>
        </div>

        <!-- Password -->
        <div class="form-group">
            <label for="passwd">Password</label>
            <input type="password" class="form-control" id="passwd" name="passwd" value="${user.passwd}" required>
        </div>
        
        <!-- Is Admin -->
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="is_admin" name="is_admin" ${user.is_admin ? "checked" : ""}>
            <label class="form-check-label" for="is_admin">Is Admin</label>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Lưu</button>
        <a href="${pageContext.request.contextPath}/admin/user" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<!-- Bootstrap JS và các thư viện phụ thuộc -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
