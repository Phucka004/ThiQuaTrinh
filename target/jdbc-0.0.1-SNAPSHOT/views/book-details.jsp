<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    
    <h2>Book Details</h2>
    <table border="1">
        <tr>
            <td>Title:</td>
            <td>${book.title}</td>
        </tr>
        <tr>
            <td>Author:</td>
            <td>${authors[0].author_name}</td>
        </tr>
        <tr>
            <td>ISBN:</td>
            <td>${book.isbn}</td>
        </tr>
        <tr>
            <td>Publisher:</td>
            <td>${book.publisher}</td>
        </tr>
        <tr>
            <td>Publisher Date:</td>
            <td>${book.publish_date}</td>
        </tr>
        <tr>
            <td>Quantity:</td>
            <td>${book.quantity}</td>
        </tr>
    </table>
    
        <h3>Reviews</h3>
    <table border="1">
        <tr>
            <th>Username</th>
            <th>Review</th>
        </tr>
        <c:forEach var="book" items="${bookD}">
        	<c:forEach var="ratings" items="${book.ratings}">
	        	<tr>
	        	<td>${ratings.user.fullname}</td>
	                <td>${ratings.review_text}</td>
	            </tr>
        	</c:forEach>
            
        </c:forEach>
    </table>

    <h3>Add a Review</h3>
    <form action="book-details" method="post">
    <input type="text" id="userid" name="userid" required value ="1"><br><br>
    <input type="text" id="bookid" name="bookid" required value = "${book.bookid}"><br><br>
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="reviewText">Review:</label><br>
        <textarea id="reviewText" name="reviewText" rows="4" cols="50" required></textarea><br><br>

        <input type="submit" value="Submit">
    </form>
