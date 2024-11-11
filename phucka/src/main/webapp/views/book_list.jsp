<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Store</title>
</head>
<body>
	<c:if test="${message != null}">${message}</c:if>
	<c:if test="${error != null}">${error}</c:if>

	<table border="1" align="center" style="width: 1000px; margin: 0 auto;">
		<tbody>
			<c:forEach var="item" items="${listbook}">
				<tr>
					
						
					<td><c:if test="${item.coverImage.substring(0,5) != 'https'}">
							<c:url value="/image?fname=${item.coverImage}" var="imgUrl"></c:url>
						</c:if> <c:if test="${item.coverImage.substring(0,5) == 'https'}">
							<c:url value="${item.coverImage}" var="imgUrl"></c:url>
						</c:if> <img height="150" width="200" src="${imgUrl}" /></td>
						
					<td><c:out value="Tiêu đề: ${item.title}" /><br> <c:out
							value="Mã isbn: ${item.isbn}" /><br> <c:out
							value="Tác giả: ${item.authorName}" /><br> <c:out
							value="Publisher: ${item.publisher}" /><br> <c:out
							value="Publish date: ${item.publishDate}" /><br> <c:out
							value="Quantity: ${item.quantity}" /><br> <c:out
							value="Review: ${item.slReview}" />
							<br>
						
						<!-- Nút "Xem chi tiết" -->
						<a class="btn btn-info" href="${pageContext.request.contextPath}/bookDetail?id=${item.bookId}" >Xem chi tiết</a>
							</td>
					
				</tr>
				
			</c:forEach>
		</tbody>
	</table>

<footer class="footer bg-light py-3 mt-5">
    <div class="container">
        <p class="text-center mb-0">Họ tên: Ka Phúc - MSSV: 22110398 - Mã đề: 2</p>
    </div>
</footer>
</body>
</html>