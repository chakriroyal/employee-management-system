<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Add Employee</title>

<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

</head>

<body>

	<!-- Navbar -->

	<div class="navbar">

		<div class="logo">EMS Dashboard</div>

		<div class="menu">

			<a href="index.jsp">Home</a> <a href="addEmployee.jsp">Add
				Employee</a> <a href="getAllEmployee">Employees</a>

		</div>

	</div>

	<!-- Form -->

	<div class="form-container">

		<div class="form-card">

			<h2>

				<i class="fa-solid fa-user-plus"></i> Add Employee

			</h2>

			<form action="saveEmployee" method="post">

				<div class="input-group">

					<label>Name</label> <input type="text" name="name"
						placeholder="Enter employee name" required>

				</div>

				<div class="input-group">

					<label>Email</label> <input type="email" name="email"
						placeholder="Enter email" required>

				</div>

				<div class="input-group">

					<label>Phone</label> <input type="number" name="phone"
						placeholder="Enter phone number" required>

				</div>

				<div class="input-group">

					<label>Salary</label> <input type="number" step="0.01"
						name="salary" placeholder="Enter salary" required>

				</div>

				<div class="input-group">

					<label>Department</label> <input type="text" name="department"
						placeholder="Enter department" required>

				</div>

				<button class="submit-btn">

					<i class="fa-solid fa-floppy-disk"></i> Save Employee

				</button>

			</form>

		</div>

	</div>

</body>

</html>