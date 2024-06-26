<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ANORMAL</title>
</head>
<body>
	<script type="text/javascript">
		alert("${requestScope.result}");
		location.href = "${requestScope.url}";
	</script>
</body>
</html>