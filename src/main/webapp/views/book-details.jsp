<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Chi Tiết Sách</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">

<%-- Kiểm tra và hiển thị lỗi nếu có --%>
<c:if test="${not empty errorMessage}">
    <div style="color: red;">
        ${errorMessage}
    </div>
</c:if>

    <h2 class="text-center mb-4">Chi Tiết Sách</h2>

    <!-- Hiển thị thông tin sách -->
    <table class="table table-bordered">
        <tr>
            <td style="width: 150px;">
                <img src="${book.cover_image}" alt="Cover Image" style="width: 100px; height: auto; object-fit: cover;">
            </td>
            <td>
                <p><strong>Tiêu đề:</strong> ${book.title}</p>
                <p><strong>Mã ISBN:</strong> ${book.isbn}</p>
                <p><strong>Tác giả:</strong> 
                <c:forEach var="author" items="${authors}">
                        ${author.authorName},
                </c:forEach></p>
                <p><strong>Publisher:</strong> ${book.publisher}</p>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <p><strong>Publisher Date:</strong> ${book.publish_date}</p>
                <p><strong>Quantity:</strong> ${book.quantity}</p>
                <a href="#" class="btn btn-primary">Reviews (10)</a>
            </td>
        </tr>
    </table>

    <h4>Reviews</h4>
<table border="1">
	<tr>
		<th>Username1</th>
		<th>Review</th>
	</tr>
		<c:forEach var="ratings" items="${bookD.ratings}">
			<tr>
				<td>${ratings.user.fullname}</td>
				<td>${ratings.review_text}</td>
			</tr>
		</c:forEach>

</table>​

    <!-- Form thêm đánh giá mới -->
    <h4>Form thêm Review</h4>

    <form action="book-details" method="post">
    <input type="hidden" name="userid" value="${sessionScope.account.getId()}">
    
        <input type="hidden" name="id" value="${book.bookid}">
       
        <div class="form-group">
            <label for="reviewText">Review:</label>
            <textarea class="form-control" id="reviewText" name="reviewText" rows="3" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
