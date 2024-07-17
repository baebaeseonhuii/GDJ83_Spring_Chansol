<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="path" value="${requestScope['javax.servlet.forward.servlet_path']}" />
<c:set var="url" value="${pageContext.request.requestURL}" />

<ul class="nav justify-content-center nav-tabs nav-pills">
  <li class="nav-item"><a class="nav-link ${path == '/' ? 'active' : ''}" href="/">HOME🏠</a></li>
  <li class="nav-item"><a class="nav-link ${path == '/notice/list' ? 'active' : ''} ${path == '/notice/update' ? 'active' : ''} ${path == '/notice/add' ? 'active' : ''} ${path == '/notice/detail' ? 'active' : ''}" href="/notice/list">공지사항📌</a></li>
  <li class="nav-item"><a class="nav-link ${path == '/qna/list' ? 'active' : ''} ${path == '/qna/update' ? 'active' : ''} ${path == '/qna/add' ? 'active' : ''} ${path == '/qna/detail' ? 'active' : ''}" href="/qna/list">QnA🤔</a></li>
  <c:choose>
    <c:when test="${empty sessionScope.member}">
      <li class="nav-item"><a class="nav-link ${path == '/members/join' ? 'active': ''}" href="/members/join">회원가입</a></li>
      <li class="nav-item"><a class="nav-link ${path == '/members/login' ? 'active': ''}" href="/members/login">로그인</a></li>
    </c:when>
    <c:otherwise>
      <li class="nav-item"><a class="nav-link ${path == '/members/mypage' ? 'active' : ''} ${path == '/members/update' ? 'active' : ''}" href="/members/mypage">마이페이지</a></li>
      <li class="nav-item"><a class="nav-link" href="/members/logout">로그아웃</a></li>
    </c:otherwise>
  </c:choose>
  <li class="nav-item"><a class="nav-link ${path == '/product/list' ? 'active' : ''} ${path == '/product/update' ? 'active' : ''} ${path == '/product/add' ? 'active' : ''} ${path == '/product/detail' ? 'active' : ''}" aria-current="page" href="/product/list">상품</a></li>
</ul>