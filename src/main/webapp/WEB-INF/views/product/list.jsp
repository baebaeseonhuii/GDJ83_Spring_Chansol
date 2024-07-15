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
        <!-- 검색 입력 폼 -->
        <form action="./list" class="row row-cols-lg-auto g-3 align-items-center">
          <div class="col-12">
            <label class="visually-hidden" for="inlineFormInputGroupUsername">Search</label>
              <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="Search">
          </div>

          <div class="col-12">
            <label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
            <select name="kind" class="form-select" id="inlineFormSelectPref">
              <option value="k1" ${map.pager.kind == 'k1' ? 'selected' : '' }>상품명</option>
              <option value="k2" ${map.pager.kind == 'k1' ? '' : 'selected' }>상품내용</option>
            </select>
          </div>

          <!-- <div class="col-12">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="inlineFormCheck"> <label class="form-check-label" for="inlineFormCheck"> Remember me </label>
            </div>
          </div> -->

          <div class="col-12">
            <button type="submit" class="btn btn-primary">검색</button>
          </div>
        </form>
        
        <br>
        
        <%-- <c:if test=""> --%>

        <%-- </c:if> --%>

        <table class="table table-hover">
          <thead>
            <tr>
              <th>PRODUCT_ID</th>
              <th>PRODUCT_NAME</th>
              <th>PRODUCT_RATE</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${requestScope.list}" var="dto">
              <tr>
                <td>${dto.item_id}</td>
                <td><a href="./detail?item_id=${dto.item_id}">${dto.item_name}</a></td>
                <td>${dto.item_rate}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <nav aria-label="Page navigation example">
          <ul class="pagination justify-content-center">
            <li class="page-item ${pager.pre ? '' : 'disabled'}"><a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
              <li class="page-item"><a class="page-link ${pager.page == i ? 'active' : ''  }" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
            </c:forEach>
            <li class="page-item ${pager.next ? '':'disabled'}"><a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
          </ul>
        </nav>
        <div class="d-md-flex justify-content-md-end">
          <a class="btn btn-primary justify-content-end" href="./add" role="button">상품등록</a>
        </div>
      </div>
    </div>
  </div>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>