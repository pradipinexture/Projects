<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- 1.Library -->
<link href="assets/library/bootstrap/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.css">

<!-- 2.custom file -->
<link href="assets/css/custom.css" type="text/css" rel="stylesheet" />
<style type="text/css">
.form-section2 {
	height: auto;
	min-height: 510px;
}

#csv-btn {
	margin-top: 3%;
	margin-left: 43%;
}
</style>

<script type="text/javascript"
	src="assets/javascript/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />

	<section class="form-section2">
		
		<c:choose>
			<c:when test="${empty users}">
				<p>Data not available.</p>
			</c:when>
			<c:otherwise>
					<table id="table_id" class="ui celled table" style="width: 100%">
						<thead>
							<tr>
								<th>Emp ID</th>
								<th>Name</th>
								<th>Email</th>
								<th>Gender</th>
								<th>Edit</th>
								<th>Delete</th>
	
							</tr>
						</thead>
						<c:forEach var="h" items="${users}">
							
							<tbody>
								<tr>
									<td><c:out value="${h.id}" /></td>
									<td><c:out value="${h.name}" /></td>
									<td><c:out value="${h.email}" /></td>
									<td><c:out value="${h.gender}" /></td>
									<td><button type="button" class="btn btn-success">Edit</button></td>
									<td><a id='<c:out value="${h.email}" />' class="btn btn-danger">Delete</a></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
					<div id="csv-btn">
						<a class="btn btn-success" href="CSVPrint">Generate CSV File</a>
					</div>	
			</c:otherwise>
		</c:choose>
	</section>



	<br>
	<jsp:include page="footer.jsp" />

	<script type="text/javascript" charset="utf8"
		src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.js"></script>
	<script>
		
	</script>
	<script>
		$(document).ready(function() {
			$(function() {
				$("#table_id").dataTable();
			});
			// crating new click event for save button
			
			$(".btn").click(function() {
				var cuEmail = $(this).attr('id');
				console.log(cuEmail);
				$.ajax({
					url : "DelUser",
					type : "post",
					data : {
						cuEmail : cuEmail,
					},
					success : function(data) {
					}
				});
				$(this).parents("tr").animate("fast").animate({
					opacity : "hide"
				}, "slow");
			});
		});
	</script>

</body>
</html>