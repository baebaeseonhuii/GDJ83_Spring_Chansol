<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container px-5">
		<a class="navbar-brand" href="/">Welcome</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/product/list">Products</a></li>
				<li class="nav-item"><a class="nav-link" href="/notice/list">Notice</a></li>
				<li class="nav-item"><a class="nav-link" href="/qna/list">QnA</a></li>
				<c:choose>
					<c:when test="${empty sessionScope.member}">
						  <li class="nav-item"><a class="nav-link ${path == '/members/join' ? 'active': ''}" href="/members/join">Join</a></li>
						  <li class="nav-item"><a class="nav-link ${path == '/members/login' ? 'active': ''}" href="/members/login">Login</a></li>
					</c:when>
					<c:otherwise>
						  <li class="nav-item"><a class="nav-link ${path == '/members/mypage' ? 'active' : ''} ${path == '/members/update' ? 'active' : ''}" href="/members/mypage">MyPage</a></li>
						  <li class="nav-item"><a class="nav-link" href="/members/logout">LogOut</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</nav>