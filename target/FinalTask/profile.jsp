<%@ page import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Page</title>
<!-- Css File links -->

<!-- 1.Library -->
<link href="assets/library/bootstrap/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<!-- 2.custom file -->
<link href="assets/css/custom.css" type="text/css" rel="stylesheet" />
<style type="text/css">
.fields *, .a-field * {
	display: inline-block;
}

.fields, .p-address, .personal h4 {
	margin: 15px;
}

.p-address .a-field {
	margin-left: 25px;
}

.personal .fields {
	margin-left: 40px;
}

label {
	font-size: 16px;
	color: blue;
}
</style>

</head>
<body>
	<jsp:include page="header.jsp" />
	<!-- Banner section -->
	<aside></aside>
	<!-- Main section for other content  -->

	<main>
	
		<div class="container">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8 col-sm-12">
					<c:out value="${pageContext.session.id}" ></c:out>
				</div>
			</div>
		</div>
	</main>
	
	<jsp:include page="footer.jsp" />

	<!-- Javascript file links -->

	<!-- 1.Already created file -->
	<script type="text/javascript"
		src="assets/javascript/jquery-3.6.0.min.js"></script>
	<!-- 2. Custom file -->
	<script type="text/javascript" src="assets/javascript/custom.js">
	
	
	</script>


</body>

</html>
