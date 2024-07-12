<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="nav justify-content-center nav-tabs nav-pills">
  <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">HOME🏠</a></li>
  <li class="nav-item"><a class="nav-link" href="/notice/list">공지사항📌</a></li>
  <c:choose>
    <c:when test="${empty sessionScope.member}">
      <li class="nav-item"><a class="nav-link" href="/members/join">회원가입</a></li>
      <li class="nav-item"><a class="nav-link" href="/members/login">로그인</a></li>
    </c:when>
    <c:otherwise>
      <li class="nav-item"><a class="nav-link" href="/members/mypage">마이페이지</a></li>
      <li class="nav-item"><a class="nav-link" href="/members/logout">로그아웃</a></li>
    </c:otherwise>
  </c:choose>
  <%--   <c:if test="${empty sessionScope.member}">
    <li class="nav-item"><a class="nav-link" href="/members/join">회원가입</a></li>
    <li class="nav-item"><a class="nav-link" href="/members/login">로그인</a></li>
  </c:if>
  <c:if test="${not empty sessionScope.member}">
    <li class="nav-item"><a class="nav-link" href="#">마이페이지</a></li>
    <li class="nav-item"><a class="nav-link" href="/members/logout">로그아웃</a></li>
  </c:if> --%>
  <li class="nav-item"><a class="nav-link" href="/product/list">상품</a></li>
</ul>