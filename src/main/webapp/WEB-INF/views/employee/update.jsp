<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE EMPLOYEE</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
  <ul class="nav justify-content-center nav-tabs nav-pills">
    <li class="nav-item"><a class="nav-link" href="/">HOME</a></li>
    <li class="nav-item"><a class="nav-link" href="/department/list">부서정보</a></li>
    <li class="nav-item"><a class="nav-link" href="/location/list">지역정보</a></li>

    <li class="nav-item"><a class="nav-link active" aria-current="page" href="/employee/list">사원정보</a></li>
  </ul>


  <br>



  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-7 col-md-9">
        <form action="./update" method="post">
          <input type="hidden" class="form-control" value="${dto.employee_id}" id="employee_id" name="employee_id">
          <div class="mb-3">
            <label for="first_name" class="form-label">이름</label>
            <input type="text" class="form-control" value="${dto.first_name}" id="first_name" name="first_name">
          </div>
          <div class="mb-3">
            <label for="last_name" class="form-label">성</label>
            <input type="text" class="form-control" value="${dto.last_name}" id="last_name" name="last_name">
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">이메일</label>
            <input type="text" class="form-control" value="${dto.email}" id="email" name="email">
          </div>
          <div class="mb-3">
            <label for="phone_number" class="form-label">핸드폰번호</label>
            <input type="text" class="form-control" value="${dto.phone_number}" id="phone_number" name="phone_number">
          </div>
          <div class="mb-3">
            <label for="hire_date" class="form-label">입사일</label>
            <input type="date" class="form-control" value="${dto.hire_date}" id="hire_date" name="hire_date">
          </div>
          <div class="mb-3">
            <label for="job_id" class="form-label">직무</label>
            <input type="text" class="form-control" value="${dto.job_id}" id="job_id" name="job_id">
          </div>
          <div class="mb-3">
            <label for="salary" class="form-label">월급($)</label>
            <input type="text" class="form-control" value="${dto.salary}" id="salary" name="salary">
          </div>
          <div class="mb-3">
            <label for="commission_pct" class="form-label">성과급비율(보너스)</label>
            <input type="text" class="form-control" value="${dto.commission_pct}"id="commission_pct" name="commission_pct">
          </div>
          <div class="mb-3">
            <label for="manager_id" class="form-label">사수의 사원번호</label>
            <input type="text" class="form-control" value="${dto.manager_id}" id="manager_id" name="manager_id">
          </div>
          <div class="mb-3">
            <label for="department_id" class="form-label">부서번호</label>
            <input type="text" class="form-control" value="${dto.department_id}" id="department_id" name="department_id">
          </div>
          <button type="submit" class="btn btn-primary">등록</button>
        </form>
      </div>
    </div>
  </div>


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>