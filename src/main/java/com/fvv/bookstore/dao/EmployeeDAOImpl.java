package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.enums.SqlQueryEnum;
import com.fvv.bookstore.exception.DaoException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;

/**
 * DAO Class of a Employee object, with main database operations from CRUD methods.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addEmployee(final Employee employee) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.EMPLOYEE_INSERT.getQuery())
		) {	
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getCpf());
			ps.setString(5, employee.getPosition());
			ps.setDouble(6, employee.getSalary());
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to add a employee", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Employee> listEmployees() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEmployee(final Employee employee) throws DaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeEmployee(final Long id) throws DaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee findEmployee(final Long id) throws PersonNotFoundException, DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
