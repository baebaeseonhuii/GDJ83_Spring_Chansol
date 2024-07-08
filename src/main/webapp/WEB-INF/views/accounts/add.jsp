<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD ACCOUNT</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/sample/headerBank.jsp"></c:import>
  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-5 col-md-6">
        <form class="row g-3" method="post" id="frm">
          <div class="col-md-12">
            <label for="bank_pw" class="form-label">계좌비밀번호</label> <input type="password" class="form-control" name="bank_pw" id="bank_pw">
          </div>
          <div class="col-md-12">
            <label for="pwval" class="form-label">계좌비밀번호 확인</label> <input type="password" class="form-control" id="pwval">
          </div>
        </form>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
          <button class="btn btn-primary me-md-2 mt-2" type="button" id="smbtn">등록</button>
        </div>
      </div>
    </div>
  </div>

  <script>
			const bank_pw = document.getElementById("bank_pw");
			const pwval = document.getElementById("pwval");
			const smbtn = document.getElementById("smbtn");
			const frm = document.getElementById("frm");
			smbtn.addEventListener("click",
					function() {
						if (bank_pw.value == "" || pwval.value == "") {
							alert("공백을 채워주세요");
						} else if (bank_pw.value*1.0 != bank_pw.value || bank_pw.value.length != 4){
							alert("4개의 숫자를 입력하세요");
						}
							else {
							if (bank_pw.value == pwval.value) {
								frm.submit();
							} else {
								alert("비밀번호를 확인하세요");
							}
						}
					})
		</script>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>