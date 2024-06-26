<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD DEPARTMENT</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
  <ul class="nav justify-content-center nav-tabs nav-pills">
    <li class="nav-item"><a class="nav-link" href="/">HOME</a></li>

    <li class="nav-item"><a class="nav-link active" aria-current="page" href="/department/list">부서정보</a></li>

    <li class="nav-item"><a class="nav-link" href="/location/list">지역정보</a></li>
    <li class="nav-item"><a class="nav-link" href="/employee/list">사원정보</a></li>
  </ul>

  <br>



  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-7 col-md-9">
        <form action="./add" method="post">
          <div class="mb-3">
            <label for="department_name" class="form-label">부서명</label> <input type="text" class="form-control" id="department_name" name="department_name">
          </div>
          <div class="mb-3">
            <label for="manager_id" class="form-label">관리자번호</label> <input type="text" class="form-control" id="manager_id" name="manager_id">
          </div>
          <div class="mb-3">
            <label for="location_id" class="form-label">지역번호</label> <input type="text" class="form-control" id="location_id" name="location_id">
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