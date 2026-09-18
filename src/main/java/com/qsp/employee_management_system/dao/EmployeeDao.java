package com.qsp.employee_management_system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.qsp.employee_management_system.entity.Employee;
import com.qsp.employee_management_system.util.HibernateUtil;

public class EmployeeDao {
	
	private static final SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public boolean saveEmployee(Employee emp) {
		
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			session.persist(emp);
			transaction.commit();
			
			return true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			if(transaction != null) {
				transaction.rollback();
			}
			
			return false;
			
		}finally {
			
			if(session != null) {
				session.close();
			}
			
		}	
		
	}
	
	public List<Employee> getAllEmployees() {

	    Session session = null;
	    List<Employee> employees = null;

	    try {
	    	
	        session = factory.openSession();
	        employees = session.createQuery("FROM Employee", Employee.class)
	                           .getResultList();
	        
	    } catch (Exception e) {
	    	
	        e.printStackTrace();
	        
	    } finally {
	    	
	        if (session != null) {
	            session.close();
	        }
	        
	    }

	    return employees;
	}
	
	public Employee getEmployeeById(Integer id) {
		Session session = null;
		try {
			session = factory.openSession();
			return session.get(Employee.class,id);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if(session != null) {
			session.close();
			}
		}
	}
	
	public boolean updateEmployee(Employee emp) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			session.merge(emp);
			transaction.commit();
			
			return true;
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			if(transaction != null) {
				transaction.rollback();
			}
			
			return false;
			
		}finally {
			
			if(session != null) {
				session.close();
			}
			
		}
	}
	
	public boolean deleteEmployee(Integer id) {

	    Session session = null;
	    Transaction transaction = null;

	    try {

	        session = factory.openSession();
	        transaction = session.beginTransaction();

	        Employee employee = session.get(Employee.class, id);

	        if (employee == null) {
	            return false;
	        }

	        session.remove(employee);
	        transaction.commit();
	        return true;

	    } catch (Exception e) {

	        e.printStackTrace();

	        if (transaction != null) {
	            transaction.rollback();
	        }

	        return false;

	    } finally {

	        if (session != null) {
	            session.close();
	        }

	    }
	}
}
