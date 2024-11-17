<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thêm Tác Giả</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <h2 class="text-center mb-4">Thêm Tác Giả</h2>
    
    <form action="${pageContext.request.contextPath}/admin/author/save" method="post">
        <!-- ID (ẩn khi thêm mới) -->
        <div class="form-group">
            <label for="authorId">Author ID</label>
            <input type="text" class="form-control" id="authorId" name="authorId" placeholder="Author ID" readonly>
        </div>

        <!-- Author Name -->
        <div class="form-group">
            <label for="authorName">Tên Tác Giả</label>
            <input type="text" class="form-control" id="authorName" name="author_name" placeholder="Nhập tên tác giả" required>
        </div>

        <!-- Date of Birth -->
        <div class="form-group">
            <label for="dateOfBirth">Ngày Sinh</label>
            <input type="date" class="form-control" id="dateOfBirth" name="date_of_birth" placeholder="Nhập ngày sinh" required>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Lưu</button>
        <a href="${pageContext.request.contextPath}/admin/author" class="btn btn-secondary">Quay lại</a>
    </form>
</div>

<!-- Bootstrap JS và các thư viện phụ thuộc -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>