<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thêm User</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Thêm User</h2>
    
    <form action="${pageContext.request.contextPath}/admin/user/save" method="post">
        <!-- ID (ẩn khi thêm mới) -->
        <div class="form-group">
            <label for="id">User ID</label>
            <input type="text" class="form-control" id="id" name="id" placeholder="User ID" readonly>
        </div>

        <!-- Email -->
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Nhập email" required>
        </div>

        <!-- Full Name -->
        <div class="form-group">
            <label for="fullname">Full Name</label>
            <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Nhập họ tên" required>
        </div>

        <!-- Phone -->
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" class="form-control" id="phone" name="phone" placeholder="Nhập số điện thoại" required>
        </div>

        <!-- Password -->
        <div class="form-group">
            <label for="passwd">Password</label>
            <input type="password" class="form-control" id="passwd" name="passwd" placeholder="Nhập mật khẩu" required>
        </div>
        
        <!-- Is Admin -->
        <div class="form-group form-check">
            <input type="checkbox" class="form-check-input" id="is_admin" name="is_admin">
            <label class="form-check-label" for="is_admin">Is Admin</label>
        </div>
        


        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Lưu</button>
        <a href="/userList" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
<!-- Bootstrap JS và các thư viện phụ thuộc -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
