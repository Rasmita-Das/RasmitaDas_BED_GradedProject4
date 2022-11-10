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

<title>Save Student</title>
</head>
<body>
	
	<div class="registration-form">
		<p class="form-header">Student details form</p>
		<form action="/StudentFestClgFest/students/save" method="POST">
			<input type="hidden" name="id" value="${student.id}" />
	
			<div>
				<p>First Name</p>
				<input type="text" name="firstName" value="${student.firstName}" placeholder="Eg: John" required>
			</div>
			<div>
				<p>Last Name</p>
				<input type="text" name="lastName" value="${student.lastName}" placeholder="Eg: Smith" required>
			</div>
			<div>
				<p>Course</p>
				<input type="text" name="course" value="${student.course}" placeholder="Eg: IT" required>
			</div>
			<div>
				<p>Country</p>
				<input type="text" name="country" value="${student.country}" placeholder="Eg: India">
			</div>
			<button type="submit" class="save-button">Submit</button>
		</form>
		<a href="/StudentFestClgFest/students/list">Back to view list of students</a>
	</div>

</body>
</html>
