<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body class="bg-light">
<c:import url="../template/navbar.jsp"></c:import>
<section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="rounded-3 py-5 px-4 px-md-5 mb-5">
                        <div class="text-center mb-5">

                            <h1 class="fw-bolder">로그인</h1>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form method="post" id="contactForm" data-sb-form-api-token="API_TOKEN">
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="member_id" value="${requestScope.remember}" id="member_id" type="text" placeholder="Enter your ID..." data-sb-validations="required" />
                                        <label for="member_id">ID</label>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">ID is required.</div>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control" id="member_pw" name="member_pw" type="password" placeholder="Enter your password..." data-sb-validations="required" />
                                        <label for="member_pw">Password</label>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">Password is required.</div>
                                    </div>
                                    <!-- Email address input-->
                                    <div class="form-check mb-5">
            							<input class="form-check-input" type="checkbox" id="gridCheck" name="remember"> 
            							<label class="form-check-label" for="gridCheck"> ID저장 </label>
          							</div>
                                                                    
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-secondary btn-lg" id="submitButton" type="submit">Submit</button></div>
                                </form>
                            </div>
                        </div>
                    </div>  
                </div>
            </section>



<footer class="fixed-bottom">
<c:import url="../template/footer.jsp"></c:import>
</footer>
<c:import url="../template/footerJS.jsp"></c:import>
</body>
</html>