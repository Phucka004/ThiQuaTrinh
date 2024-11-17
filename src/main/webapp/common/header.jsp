<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Phần Header -->
<header class="mb-4">
	<!-- Main Navigation Bar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div
			class="container d-flex align-items-center justify-content-between">
			<a class="navbar-brand" href="#">Trang Chủ</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<ul class="navbar-nav ml-auto d-flex align-items-center">
				<!-- Link to Products -->
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/books">Sản
						phẩm</a></li>
				<!-- Chỉ hiển thị "Trang quản trị" nếu người dùng có vai trò admin -->
				<c:if test="${sessionScope.account.getIs_admin()}">
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/author">Trang
							quản trị</a></li>
				</c:if>


				<div class="collapse navbar-collapse" id="navbarNav">


					<!-- User Authentication Links -->
					<c:choose>
						<c:when test="${sessionScope.account == null}">
							<!-- Links for Login and Register if user is not logged in -->
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/login">Login</a></li>
						</c:when>
						<c:otherwise>
							<!-- Show username and Logout if user is logged in -->
							<li class="nav-item"><a class="nav-link">${sessionScope.account.getFullname()}</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/logout">Logout</a></li>
						</c:otherwise>
					</c:choose>
			</ul>
		</div>
		</div>
	</nav>
</header>
