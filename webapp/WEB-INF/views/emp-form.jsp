<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Employee</title>
</head>

<body>

	<div class="container">

		<h3>Employee Directory</h3>
		<hr>

		<p class="h4 mb-4">Enter Employee</p>

		<form action="/EmployeeManagement/employee/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Employee.id}" />


			<div class="form-inline">
				<input type="text" name="name" value="${Employee.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">
			</div>


			<div class="form-inline">
				<input type="text" name="category" value="${Employee.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>


			<div class="form-inline">
				<input type="text" name="author" value="${Book.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>


			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/EmployeeManagement/employee/list">Back to Employee List</a>

	</div>
</body>

</html>