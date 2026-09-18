<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Employee Management System</title>

<link rel="stylesheet" href="css/style.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">

</head>

<body>

	<div class="navbar">

		<div class="logo">EMS Dashboard</div>

		<div class="menu">

			<a href="index.jsp">Home</a> <a href="addEmployee.jsp">Add
				Employee</a> <a href="getAllEmployee">Employees</a>

		</div>

	</div>


	<div class="hero">

		<h1>Employee Management System</h1>

		<p>Manage your employees with a modern dashboard</p>

	</div>


	<div class="container">

		<div class="card">

			<i class="fa-solid fa-user-plus"></i>

			<h2>Add Employee</h2>

			<p>Create a new employee record.</p>

			<a href="addEmployee.jsp" class="btn"> Open </a>

		</div>


		<div class="card">

			<i class="fa-solid fa-users"></i>

			<h2>View Employees</h2>

			<p>See all employee information.</p>

			<a href="getAllEmployee" class="btn"> Open </a>

		</div>


		<div class="card">

			<i class="fa-solid fa-user-pen"></i>

			<h2>Update Employee</h2>

			<p>Edit employee details.</p>

			<a href="getAllEmployee" class="btn"> Open </a>

		</div>


		<div class="card">

			<i class="fa-solid fa-trash"></i>

			<h2>Delete Employee</h2>

			<p>Delete existing employees.</p>

			<a href="getAllEmployee" class="btn"> Open </a>

		</div>

	</div>

</body>

</html>