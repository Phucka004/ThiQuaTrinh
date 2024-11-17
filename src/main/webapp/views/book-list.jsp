<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh sách Sách của Tác Giả</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body class="container mt-5">
    <h2 class="text-center mb-4">Danh sách Sách của Tác Giả</h2>

    <c:forEach var="entry" items="${authorBooks}">
        <c:set var="author" value="${entry.key}" />
        <c:set var="books" value="${entry.value}" />

        <div class="mb-4">
            <h3>Tác giả: ${author.authorName}</h3>
            <table class="table table-bordered">
                <c:forEach var="book" items="${books}">
                    <tr>
                        <!-- Cột hiển thị ảnh bìa -->
                        <td style="width: 150px;">
                            <img src="${book.cover_image}" alt="Cover Image" style="width: 100px; height: auto; object-fit: cover;">
                        </td>
                        <!-- Cột hiển thị thông tin sách -->
                        <td>
                            <p><strong>Tiêu đề:</strong> ${book.title}</p>
                            <p><strong>Mã ISBN:</strong> ${book.isbn}</p>
                            <p><strong>Publisher:</strong> ${book.publisher}</p>
                            <p><strong>Publisher Date:</strong> ${book.publish_date}</p>
                            <p><strong>Quantity:</strong> ${book.quantity}</p>
                            <a href="book-details?id=${book.bookid}" class="btn btn-info">Chi tiết</a>
                            <a href="#" class="btn btn-primary">Review (10)</a>
                        </td>
                         
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:forEach>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
