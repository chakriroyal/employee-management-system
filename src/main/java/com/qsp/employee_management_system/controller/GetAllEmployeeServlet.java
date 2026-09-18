package com.qsp.employee_management_system.controller;

import java.io.IOException;
import java.util.List;

import com.qsp.employee_management_system.entity.Employee;
import com.qsp.employee_management_system.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getAllEmployee")
public class GetAllEmployeeServlet extends HttpServlet {
	
	private final EmployeeService employeeService = new EmployeeService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Employee> employees = employeeService.getAllEmployees();

        req.setAttribute("employees", employees);
        req.getRequestDispatcher("display.jsp").forward(req, resp);
	}
}
