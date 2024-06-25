<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOCATIONS LIST</title>



<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

</head>


<body>
	<ul class="nav justify-content-center nav-tabs nav-pills">
		<li class="nav-item"><a class="nav-link" href="/">HOME</a></li>
		<li class="nav-item"><a class="nav-link" href="/department/list">부서정보</a></li>

		<li class="nav-item"><a class="nav-link active"
			aria-current="page" href="/location/list">지역정보</a></li>

		<li class="nav-item"><a class="nav-link" href="/employee/list">사원정보</a></li>
	</ul>
	
	<br>
	
	<div class="container text-center">
		<div class="row justify-content-center">
			<div class="col-lg-10">
				<table class="table table-primary table-striped table-hover">
					<thead>
						<tr>
							<th>지역번호</th>
							<th>도로명주소</th>
							<th>우편번호</th>
							<th>도시</th>
							<th>주</th>
							<th>국가코드</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${requestScope.list}" var="dto">
							<tr>
								<td>${pageScope.dto.location_id}</td>
								<td>${pageScope.dto.street_address}</td>
								<td>${pageScope.dto.postal_code}</td>
								<td>${pageScope.dto.city}</td>
								<td>${pageScope.dto.state_province}</td>
								<td>${pageScope.dto.country_id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>