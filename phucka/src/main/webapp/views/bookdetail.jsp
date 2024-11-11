<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết sách</title>
    <!-- Thêm Bootstrap cho giao diện đẹp -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>Chi tiết sách</h2>

        <!-- Hiển thị thông tin chi tiết của cuốn sách -->
        <div class="row">
            <div class="col-md-4">
                <!-- Hiển thị ảnh bìa của sách -->
                <c:if test="${item.coverImage != null}">
                    <c:url value="/image?fname=${item.coverImage}" var="imgUrl"/>
                    <img class="img-fluid" src="${imgUrl}" alt="Cover Image">
                </c:if>
            </div>
            <div class="col-md-8">
                <!-- Hiển thị các thông tin khác về sách -->
                <p><strong>Tiêu đề:</strong> ${item.title}</p>
                <p><strong>Mã ISBN:</strong> ${item.isbn}</p>
                <p><strong>Tác giả:</strong> ${item.authorName}</p>
                <p><strong>Nhà xuất bản:</strong> ${item.publisher}</p>
                <p><strong>Ngày xuất bản:</strong> <fmt:formatDate value="${item.publishDate}" pattern="dd/MM/yyyy"/></p>
                <p><strong>Số lượng:</strong> ${item.quantity}</p>
                <p><strong>Số lượng đánh giá:</strong> ${item.slReview}</p>
            </div>
        </div>

        <!-- Phần đánh giá của sách -->
        <div class="mt-4">
            <h5>Đánh giá</h5>
            <!-- Hiển thị các đánh giá đã có -->
            <c:forEach var="review" items="${item.reviews}">
                <div class="review-item mb-3">
                    <p><strong>${review.userName}:</strong> ${review.reviewText}</p>
                </div>
            </c:forEach>
        </div>

        <!-- Form thêm đánh giá -->
        <div class="mt-4">
            <h5>Thêm đánh giá</h5>
            <form action="${pageContext.request.contextPath}/addReview" method="POST">
                <input type="hidden" name="bookid" value="${item.bookid}" />
                <div class="form-group">
                    <label for="reviewText">Đánh giá của bạn:</label>
                    <textarea id="reviewText" name="reviewText" class="form-control" rows="4" required></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Gửi đánh giá</button>
            </form>
        </div>

        <!-- Link quay lại danh sách sách -->
        <div class="mt-4">
            <a href="${pageContext.request.contextPath}/listbook" class="btn btn-secondary">Quay lại danh sách sách</a>
        </div>
    </div>

    <!-- Thêm Bootstrap JS, Popper.js -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
