<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankOfChansol</title>
<c:import url="./template/header_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
<h1>hi</h1>
	<main class="flex-shrink-0">
	<!-- Navigation-->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
             <div class="container px-5">
                 <a class="navbar-brand" href="/">Welcome</a>
                 <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                 <div class="collapse navbar-collapse" id="navbarSupportedContent">
                     <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                         <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                         <li class="nav-item"><a class="nav-link" href="#features">Products</a></li>
                         <li class="nav-item"><a class="nav-link" href="#notice">Notice</a></li>
                         <li class="nav-item"><a class="nav-link" href="/qna/list">QnA</a></li>
                         <c:choose>
						    <c:when test="${empty sessionScope.member}">
						      <li class="nav-item"><a class="nav-link ${path == '/members/join' ? 'active': ''}" href="/members/join">Join</a></li>
						      <li class="nav-item"><a class="nav-link ${path == '/members/login' ? 'active': ''}" href="/members/login">Login</a></li>
						    </c:when>
						    <c:otherwise>
						      <li class="nav-item"><a class="nav-link ${path == '/members/mypage' ? 'active' : ''} ${path == '/members/update' ? 'active' : ''}" href="/members/mypage">MyPage</a></li>
						      <li class="nav-item"><a class="nav-link" href="/members/logout">로그아웃</a></li>
						    </c:otherwise>
						 </c:choose>
                     </ul>
                 </div>
             </div>
         </nav>
         
         <!-- Header-->
         <header class="bg-dark py-5">
                <div class="container px-5">
                    <div class="row gx-5 align-items-center justify-content-center">
                        <div class="col-lg-8 col-xl-7 col-xxl-6">
                            <div class="my-5 text-center text-xl-start">
                                <h1 class="display-5 fw-bolder text-white mb-2">Chansol Bank</h1>
                                <p class="lead fw-normal text-white-50 mb-4">당장 가입하세요</p>
                                <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start">
                                    <a class="btn btn-outline-light btn-lg px-4" href="/members/login">Sign in</a>
                                    <a class="btn btn-outline-light btn-lg px-4" href="/members/join">Sign up</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center"><img class="img-fluid rounded-3 my-5" src="https://merriam-webster.com/assets/mw/images/article/art-wap-landing-mp-lg/meme-boy-gets-paid-4140-c9dfc888677499743410feaf017cfa46@1x.jpg" alt="..." /></div>
                    </div>
                </div>
            </header>
            
            <!-- Features section-->
            <section class="py-5" id="features">
                <div class="container px-5 my-5">
                    <div class="row gx-5">
                        <div class="col-lg-4 mb-5 mb-lg-0"><h2 class="fw-bolder mb-0">A better way to be financially stable.</h2></div>
                        <div class="col-lg-8">
                            <div class="row gx-5 row-cols-1 row-cols-md-2">
                                <div class="col mb-5 h-100">
                                    <div class="feature text-white rounded-3 mb-3 border-3">
                                    <a class="btn btn-outline-success" href="./product/list"><i class="bi bi-cash-coin"></i></a></div>
                                    <h2 class="h5">저희 상품 많아요</h2>
                                    <p class="mb-0">아이콘을 눌러주세요</p>
                                </div>
                                <div class="col mb-5 h-100">
                                    <div class="feature bg-gradient text-white rounded-3 mb-3 border-3">
                                    <a class="btn btn-outline-success" href="./product/list"><i class="bi bi-piggy-bank"></i></a>
                                    </div>
                                    <h2 class="h5">이자율도 높아요</h2>
                                    <p class="mb-0">구경해주세요</p>
                                </div>
                                <div class="col mb-5 h-100">
                                    <div class="feature bg-gradient text-white rounded-3 mb-3 border-3">
                                    <a class="btn btn-outline-success" href="./product/list"><i class="bi bi-wallet-fill"></i>
                                    </a>
                                    </div>
                                    <h2 class="h5">상품구경하고가세요</h2>
                                    <p class="mb-0">제발</p>
                                </div>
                                <div class="col mb-5 h-100">
                                    <div class="feature bg-gradient text-white rounded-3 mb-3 border-3">
                                    <a class="btn btn-outline-success" href="./product/list"><i class="bi bi-person"></i></a>
                                    </div>
                                    <h2 class="h5">튼튼한 금융설계</h2>
                                    <p class="mb-0">해드립니다</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            
            <!-- Testimonial section-->
            <div class="py-5 bg-light">
                <div class="container px-5 my-5">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-10 col-xl-7">
                            <div class="text-center">
                                <div class="fs-4 mb-4 fst-italic">"Working with Chansol Bank is the greatest experience ever!"</div>
                                <div class="d-flex align-items-center justify-content-center">
                                    <img class="rounded-circle me-3 sm" src="/resources/images/index/green.jpg" alt="..." />
                                    <div class="fw-bold">
                                        Goodee
                                        <span class="fw-bold text-primary mx-1">/</span>
                                        Academy
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Blog preview section-->
            <section class="py-5" id="notice">
                <div class="container px-5 my-5">
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-8 col-xl-6">
                            <div class="text-center">
                                <h2 class="fw-bolder">공지사항</h2>
                                <p class="lead fw-normal text-muted mb-5">확인하세요</p>
                            </div>
                        </div>
                    </div>
                    <div class="row gx-5">
                        <div class="col-lg-4 mb-5">
                            <div class="card h-100 shadow border-0">
                                <img class="card-img-top" src="/resources/images/index/notice/finance1.jpg" alt="people farming" />
                                <div class="card-body p-4">
                                    <div class="badge bg-primary bg-gradient rounded-pill mb-2">News</div>
                                    <a class="text-decoration-none link-dark stretched-link" href="/notice/list"><h5 class="card-title mb-3">Blog post title</h5></a>
                                    <p class="card-text mb-0">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                                <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                                    <div class="d-flex align-items-end justify-content-between">
                                        <div class="d-flex align-items-center">
                                            <img class="rounded-circle me-3" src="https://dummyimage.com/40x40/ced4da/6c757d" alt="..." />
                                            <div class="small">
                                                <div class="fw-bold">Kelly Rowan</div>
                                                <div class="text-muted">March 12, 2023 &middot; 6 min read</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 mb-5">
                            <div class="card h-100 shadow border-0">
                                <img class="card-img-top" src="/resources/images/index/notice/finance2.jpg" alt="bunch of dollars" />
                                <div class="card-body p-4">
                                    <div class="badge bg-primary bg-gradient rounded-pill mb-2">Media</div>
                                    <a class="text-decoration-none link-dark stretched-link" href="/notice/list"><h5 class="card-title mb-3">Another blog post title</h5></a>
                                    <p class="card-text mb-0">This text is a bit longer to illustrate the adaptive height of each card. Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                                <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                                    <div class="d-flex align-items-end justify-content-between">
                                        <div class="d-flex align-items-center">
                                            <img class="rounded-circle me-3" src="https://dummyimage.com/40x40/ced4da/6c757d" alt="..." />
                                            <div class="small">
                                                <div class="fw-bold">Josiah Barclay</div>
                                                <div class="text-muted">March 23, 2023 &middot; 4 min read</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 mb-5">
                            <div class="card h-100 shadow border-0">
                                <img class="card-img-top" src="/resources/images/index/notice/finance3.jpg" alt="stacks of coins" />
                                <div class="card-body p-4">
                                    <div class="badge bg-primary bg-gradient rounded-pill mb-2">News</div>
                                    <a class="text-decoration-none link-dark stretched-link" href="/notice/list"><h5 class="card-title mb-3">The last blog post title is a little bit longer than the others</h5></a>
                                    <p class="card-text mb-0">Some more quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                                <div class="card-footer p-4 pt-0 bg-transparent border-top-0">
                                    <div class="d-flex align-items-end justify-content-between">
                                        <div class="d-flex align-items-center">
                                            <img class="rounded-circle me-3" src="https://dummyimage.com/40x40/ced4da/6c757d" alt="..." />
                                            <div class="small">
                                                <div class="fw-bold">Evelyn Martinez</div>
                                                <div class="text-muted">April 2, 2023 &middot; 10 min read</div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
     
	</main>
	
<c:import url="./template/footer.jsp"></c:import>
<c:import url="./template/footerJS.jsp"></c:import>
</body>
</html>