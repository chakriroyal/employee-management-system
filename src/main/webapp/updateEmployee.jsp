<%@page import="com.qsp.employee_management_system.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
Employee employee = (Employee) request.getAttribute("employee");

if (employee == null) {
	response.sendRedirect("getAllEmployee");
	return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>

<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

</head>

<body>

	<!-- Navbar -->

	<div class="navbar">

		<div class="logo">
			<i class="fa-solid fa-users"></i> Employee Management
		</div>

		<div class="menu">
			<a href="index.jsp">Home</a> <a href="addEmployee.jsp">Add
				Employee</a> <a href="getAllEmployee">Employees</a>
		</div>

	</div>

	<!-- Update Card -->

	<div class="container">

		<div class="form-card">

			<h2>

				<i class="fa-solid fa-user-pen"></i> Update Employee

			</h2>

			<form action="updateEmployee" method="post">

				<div class="input-group">

					<label>Employee ID</label> <input type="number" name="id"
						value="<%=employee.getId()%>" readonly>

				</div>

				<div class="input-group">

					<label>Name</label> <input type="text" name="name"
						value="<%=employee.getName()%>" required>

				</div>

				<div class="input-group">

					<label>Email</label> <input type="email" name="email"
						value="<%=employee.getEmail()%>" required>

				</div>

				<div class="input-group">

					<label>Phone</label> <input type="tel" name="phone"
						value="<%=employee.getPhone()%>" pattern="[6-9][0-9]{9}" required>

				</div>

				<div class="input-group">

					<label>Salary</label> <input type="number" name="salary"
						step="0.01" value="<%=employee.getSalary()%>" required>

				</div>

				<div class="input-group">

					<label>Department</label> <input type="text" name="department"
						value="<%=employee.getDepartment()%>" required>

				</div>

				<div class="button-group">

					<button class="update-btn" type="submit">

						<i class="fa-solid fa-floppy-disk"></i> Update Employee

					</button>

					<a href="getAllEmployee" class="cancel-btn"> <i
						class="fa-solid fa-arrow-left"></i> Cancel

					</a>

				</div>

			</form>

		</div>

	</div>

</body>
</html>