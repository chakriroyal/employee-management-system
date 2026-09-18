package com.qsp.employee_management_system.service;

import java.util.List;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.entity.Employee;

public class EmployeeService {
	
	private final EmployeeDao employeeDao = new EmployeeDao();
	
	public boolean validateEmployee(Employee employee) {
		
		String name = employee.getName();
		String email = employee.getEmail();
		Long phone = employee.getPhone();
		Double salary = employee.getSalary();
		String department = employee.getDepartment();
		
		if(  name == null || name.isBlank() ) {
			System.out.println("Name cannot be empty or null");
			return false;
		}else if( salary == null || salary <= 0  ) {
			System.out.println("Salary cannot be in nagative or zero");
			return false;
		}else if( email == null || email.isBlank() || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") ) {
			System.out.println("Invalid email");
			return false;
		}else if( phone == null || phone.toString().length() != 10 || !phone.toString().matches("[6-9][0-9]{9}") ){
			System.out.println("Invalid number");
			return false;
		}else if( department == null || department.isBlank() ) {
			System.out.println("Department cannot be empty or null");
			return false;
		}
		return true;
	}
	
	public boolean saveEmployee(Employee employee) {
		
		if(validateEmployee(employee) && employeeDao.saveEmployee(employee)) {
			return true;
		}
		return false;
	}
	
	public List<Employee> getAllEmployees() {
	    return employeeDao.getAllEmployees();
	}
	
	public Employee getEmployeeById(Integer id) {
		return employeeDao.getEmployeeById(id);
	}
	
	public boolean updateEmployee(Employee employee) {
	    if (validateEmployee(employee)) {
	        return employeeDao.updateEmployee(employee);
	    }
	    return false;
	}
	
	public boolean deleteEmployee(Integer id) {
	    return employeeDao.deleteEmployee(id);
	}
}
