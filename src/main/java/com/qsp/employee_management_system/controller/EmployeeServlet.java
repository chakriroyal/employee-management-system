package com.qsp.employee_management_system.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.qsp.employee_management_system.entity.Employee;
import com.qsp.employee_management_system.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saveEmployee")
public class EmployeeServlet extends HttpServlet{
	
	private final EmployeeService employeeService = new EmployeeService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		try {
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			Long phone = Long.parseLong(req.getParameter("phone"));
			Double salary = Double.parseDouble(req.getParameter("salary"));
			String department = req.getParameter("department");
			
			Employee employee = new Employee();
			employee.setName(name);
			employee.setEmail(email);
			employee.setPhone(phone);
			employee.setSalary(salary);
			employee.setDepartment(department);
			
			boolean saveResult = employeeService.saveEmployee(employee);
			resp.setContentType("text/html");
			if(saveResult){
			    resp.sendRedirect("getAllEmployee?success=Employee Added Successfully");
			}else{
			    resp.sendRedirect("addEmployee.jsp?error=Unable to Add Employee");
			}
		}catch(NumberFormatException e) {
			pw.print("Phone number and salary should contain only numbers...");
		}catch(Exception e) {
			pw.print("Something went wrong! please try again...");
		}
	}
}
