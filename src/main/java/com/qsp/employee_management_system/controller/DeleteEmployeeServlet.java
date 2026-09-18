package com.qsp.employee_management_system.controller;

import java.io.IOException;

import com.qsp.employee_management_system.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet{
	private final EmployeeService employeeService = new EmployeeService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 Integer id = Integer.parseInt(req.getParameter("id"));

	        boolean result = employeeService.deleteEmployee(id);

	        if (result) {
	        	resp.sendRedirect("getAllEmployee?success=Employee Deleted Successfully");
	        } else {
	            resp.getWriter().println("Employee not found.");
	        }
	}
}
