<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-7 col-md-9">

        <form action="update" method="post" id="frm">
          <div class="col-md-12 mt-2">
            <label for="member_name" class="form-label">FULL NAME</label> <input type="text" class="form-control" name="member_name" id="member_name" value="${member.member_name}">
          </div>
          <div class="col-md-12 mt-2">
            <label for="member_phone" class="form-label">PHONE NUMBER</label> <input type="text" class="form-control" name="member_phone" id="member_phone" value="${member.member_phone}">
          </div>
          <div class="col-md-12 mt-2">
            <label for="member_email" class="form-label">EMAIL</label> <input type="email" class="form-control" name="member_email" id="member_email" value="${member.member_email}">
          </div>

        </form>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
          <button class="btn btn-primary me-md-2 mt-2" type="button" id="smbtn">수정</button>
        </div>
      </div>
    </div>
  </div>

  <script>
			const member_name = document.getElementById("member_name");
			const member_phone = document.getElementById("member_phone");
			const member_email = document.getElementById("member_email");
			const smbtn = document.getElementById("smbtn");
			const frm = document.getElementById("frm");
			smbtn.addEventListener("click",
					function() {
						if (	member_name.value == ""
								|| member_phone.value == ""
								|| member_email.value == "") {
							
							alert("공백을 채워주세요");
							
						} else {

							frm.submit();

						}
					})
		</script>

  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>