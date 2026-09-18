<%@page import="java.util.List"%>
<%@page import="com.qsp.employee_management_system.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Employees</title>

<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

</head>

<body>

	<%
	String success = request.getParameter("success");
	String error = request.getParameter("error");
	%>

	<%
	if (success != null) {
	%>

	<div class="success-message">
		<%=success%>
	</div>

	<%
	}
	%>

	<%
	if (error != null) {
	%>

	<div class="error-message">
		<%=error%>
	</div>

	<%
	}
	%>

	<div class="navbar">

		<div class="logo">EMS Dashboard</div>

		<div class="menu">

			<a href="index.jsp">Home</a> <a href="addEmployee.jsp">Add
				Employee</a> <a href="getAllEmployee">Employees</a>

		</div>

	</div>

	<%
	List<Employee> employees = (List<Employee>) request.getAttribute("employees");
	%>

	<div class="table-container">

		<div class="table-header">

			<h2>

				<i class="fa-solid fa-users"></i> Employee Details

			</h2>

			<input type="text" id="search" class="search-box"
				placeholder="Search Employee...">

		</div>

		<%
		if (employees != null && !employees.isEmpty()) {
		%>

		<table id="employeeTable">

			<thead>

				<tr>

					<th>ID</th>

					<th>Name</th>

					<th>Email</th>

					<th>Phone</th>

					<th>Salary</th>

					<th>Department</th>

					<th>Actions</th>

				</tr>

			</thead>

			<tbody>

				<%
				for (Employee e : employees) {
				%>

				<tr>

					<td><%=e.getId()%></td>

					<td><%=e.getName()%></td>

					<td><%=e.getEmail()%></td>

					<td><%=e.getPhone()%></td>

					<td><%=e.getSalary()%></td>

					<td><%=e.getDepartment()%></td>

					<td><a href="updateEmployee?id=<%=e.getId()%>"
						class="action-btn update-btn"> <i class="fa-solid fa-pen"></i>

							Update

					</a> <a href="deleteEmployee?id=<%=e.getId()%>"
						class="action-btn delete-btn"
						onclick="return confirm('Delete this employee?')"> <i
							class="fa-solid fa-trash"></i> Delete

					</a></td>

				</tr>

				<%
				}
				%>

			</tbody>

		</table>

		<%
		} else {
		%>

		<div class="no-data">No Employees Found</div>

		<%
		}
		%>

	</div>

	<script>
		document.getElementById("search").addEventListener("keyup", function() {

			let value = this.value.toLowerCase();

			let rows = document.querySelectorAll("#employeeTable tbody tr");

			rows.forEach(function(row) {

				let text = row.innerText.toLowerCase();

				row.style.display = text.includes(value) ? "" : "none";

			});

		});
	</script>

</body>

</html>