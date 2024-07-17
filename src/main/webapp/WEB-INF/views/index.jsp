<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-7 col-md-9">

        <c:if test="${not empty sessionScope.member}">
          <div>
            <h3>${sessionScope.member.member_name}님 환영합니다</h3>
            <br>
            <h3>사이트 주인 계좌번호: 001100000015</h3>
            <h3>많은 후원 부탁드립니다 ^^</h3>
          </div>
        </c:if>

        <div id="carouselExampleIndicators" class="carousel slide">
          <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="/resources/images/index/bird-8788491_1920.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
              <img src="/resources/images/index/ai-generated-8327632_1920.jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
              <img src="/resources/images/index/squirrel-8536537_1920.jpg" class="d-block w-100" alt="...">
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
    </div>
  </div>

  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>