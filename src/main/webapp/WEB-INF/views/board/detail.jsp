<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT LIST</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-7 col-md-9">
      <c:choose>
        <c:when test="${sessionScope.member.member_id == dto.boardWriter}">
        <div class="d-md-flex justify-content-md-end">
          <a class="btn btn-primary justify-content-end me-2" href="./update?boardNum=${dto.boardNum}" role="button">수정</a>
          <a class="btn btn-primary justify-content-end" href="./delete?boardNum=${dto.boardNum}" role="button">삭제</a>
        </div>
        </c:when>
      </c:choose>

        <table class="table table-hover">
          <thead>
            <tr>
              <th>글번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>조회수</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>${dto.boardNum}</td>
              <td>${dto.boardTitle}</td>
              <td>${dto.boardWriter}</td>
              <td>${dto.createDate}</td>
              <td>${dto.boardHit}</td>
            </tr>
            <tr>
              <td colspan='5'>세부정보: ${dto.boardContents}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>