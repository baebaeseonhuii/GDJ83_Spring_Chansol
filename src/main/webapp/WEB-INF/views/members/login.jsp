<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-5 col-md-6">
        <form class="row g-3" method="post">
          <div class="col-md-12">
            <label for="member_id" class="form-label">ID</label> <input type="text" class="form-control" name="member_id" value="${requestScope.remember}">
          </div>
          <div class="col-md-12">
            <label for="member_pw" class="form-label">PW</label> <input type="password" class="form-control" name="member_pw">
          </div>
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck" name="remember"> <label class="form-check-label" for="gridCheck"> ID저장 </label>
          </div>
          <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-primary me-md-2 mt-2" type="submit">로그인</button>
          </div>
        </form>
      </div>
    </div>
  </div>


  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>