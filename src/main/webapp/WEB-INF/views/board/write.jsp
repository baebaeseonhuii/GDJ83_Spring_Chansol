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
        <form class="row g-3 mt-3 justify-content-center" method="post">
          <input type="hidden" value="${dto.boardNum}" name="boardNum">
          <div class="col-md-12">
            <h1>${board}작성</h1>
            <label for="member_id" class="form-label">작성자</label> <input type="text" class="form-control" name="member_name" value="${member.member_id}" disabled>
          </div>
          <div class="col-md-12">
            <label for="boardTitle" class="form-label">글제목</label> <input type="text" class="form-control" name="boardTitle" value="${dto.boardTitle}">
          </div>
          <div class="col-md-12">
            <label for="boardContents" class="form-label">글내용</label>
            <textarea class="form-control" name="boardContents">${dto.boardContents}</textarea>
          </div>
          <div class="d-md-flex justify-content-md-end">
            <button class="btn btn-primary me-mt-2" type="submit">등록</button>
          </div>
        </form> 
      </div>
    </div>
  </div>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>