package com.qsp.employee_management_system.controller;

import java.io.IOException;

import com.qsp.employee_management_system.entity.Employee;
import com.qsp.employee_management_system.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet{
	private final EmployeeService employeeService = new EmployeeService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Employee emp = employeeService.getEmployeeById(id);
		if (emp != null) {
		    req.setAttribute("employee", emp);
		    req.getRequestDispatcher("updateEmployee.jsp").forward(req, resp);
		} else {
		    resp.getWriter().println("Employee not found.");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    try {

	        Integer id = Integer.parseInt(req.getParameter("id"));
	        String name = req.getParameter("name");
	        String email = req.getParameter("email");
	        Long phone = Long.parseLong(req.getParameter("phone"));
	        Double salary = Double.parseDouble(req.getParameter("salary"));
	        String department = req.getParameter("department");

	        Employee emp = new Employee();
	        emp.setId(id);
	        emp.setName(name);
	        emp.setEmail(email);
	        emp.setPhone(phone);
	        emp.setSalary(salary);
	        emp.setDepartment(department);

	        boolean updateResult = employeeService.updateEmployee(emp);

	        if (updateResult) {
	        	resp.sendRedirect("getAllEmployee?success=Employee Updated Successfully");
	        } else {
	            resp.getWriter().println("Cannot update employee information.");
	        }

	    } catch (NumberFormatException e) {
	        resp.getWriter().println("Invalid numeric input.");
	    } catch (Exception e) {
	        resp.getWriter().println("Something went wrong.");
	    }
	}
}
