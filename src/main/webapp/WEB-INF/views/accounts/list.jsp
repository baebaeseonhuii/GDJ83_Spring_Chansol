<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ACCOUNT LIST</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/sample/headerBank.jsp"></c:import>
  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-7 col-md-9">

        <div>
          <c:choose>
            <c:when test="${param.order == 1}">
              <a class="btn btn-primary justify-content-end me-2" href="list?bank_id=${param.bank_id}&IO=${param.IO}">최신순으로</a>
            </c:when>
            <c:otherwise>
              <a class="btn btn-primary justify-content-end me-2" href="list?bank_id=${param.bank_id}&order=1&IO=${param.IO}">과거순으로</a>
            </c:otherwise>
          </c:choose>
          <div class="btn-group">
            <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">입출금선택</button>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="list?bank_id=${param.bank_id}&order=${param.order}&IO=1">입금만</a></li>
              <li><a class="dropdown-item" href="list?bank_id=${param.bank_id}&order=${param.order}&IO=0">출금만</a></li>
              <li><a class="dropdown-item" href="list?bank_id=${param.bank_id}&order=${param.order}">입금/출금</a></li>
            </ul>
          </div>
        </div>
        <br>
        <table class="table table-hover">
          <thead>
            <tr>
              <th>날짜</th>
              <th>구분</th>
              <th>거래금액</th>
              <th>잔액</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${requestScope.bank_infos}" var="dto">
              <tr>
                <td>${dto.timepoint}</td>
                <td class="${(dto.difference>0)?'text-primary':'text-danger'}"><c:choose>

                    <c:when test="${dto.difference>0}">
                      입금
                    </c:when>

                    <c:otherwise>
                      출금
                    </c:otherwise>

                  </c:choose></td>
                <td class="${(dto.difference>0)?'text-primary':'text-danger'}">${dto.difference}</td>
                <td>${dto.balance}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>