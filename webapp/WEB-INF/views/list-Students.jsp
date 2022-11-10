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

<title>Students Directory</title>
</head>

<body>

	
	<div class="block1">
		<div class="button-bar">
			<a href="/StudentFestClgFest/students/showFormForAdd"
				class="addStudent-button">Add Student</a>
			<a href="/StudentFestClgFest/logout"
				class="addStudent-button logout-button">Logout</a>
		</div>
		<table class="custom-table">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Course</th>
					<th>Country</th>
					<th style="text-align:center">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="tempStudent">
					<tr>
						<td><c:out value="${tempStudent.firstName}" /></td>
						<td><c:out value="${tempStudent.lastName}" /></td>
						<td><c:out value="${tempStudent.course}" /></td>
						<td><c:out value="${tempStudent.country}" /></td>
						<td style="text-align:center">
							<a href="/StudentFestClgFest/students/showFormForUpdate?studentId=${tempStudent.id}" class="update-button"> Update</a> 
							<a href="/StudentFestClgFest/students/delete?studentId=${tempStudent.id}" class="delete-button"
							onclick="if(!(confirm('Are you sure you want to delete ${tempStudent.firstName}?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>