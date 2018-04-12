package com.fvv.bookstore.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		List<Employee> employees = new ArrayList<>();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.EMPLOYEE_SELECT_ALL.getQuery());
				ResultSet rs = ps.executeQuery()
		) {	
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getLong("emp_id"));
				employee.setName(rs.getString("emp_name"));
				employee.setEmail(rs.getString("emp_email"));
				employee.setPhone(rs.getString("emp_phone"));
				employee.setCpf(rs.getString("emp_cpf"));
				employee.setPosition(rs.getString("emp_position"));
				employee.setSalary(rs.getDouble("emp_salary"));
				employee.setModificationDate(new Date(rs.getTimestamp(
						"emp_modification_date").getTime()));
				employees.add(employee);
			}
		} catch(SQLException e) {
			throw new DaoException("Error to load the list", e);
		} 
		return employees;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEmployee(final Employee employee) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.EMPLOYEE_UPDATE.getQuery())
		) {	
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getEmail());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getCpf());
			ps.setString(5, employee.getPosition());
			ps.setDouble(6, employee.getSalary());
			ps.setLong(7, employee.getId());
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to update a employee", e);
		} 
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeEmployee(final Long id) throws DaoException {
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(SqlQueryEnum.EMPLOYEE_DELETE.getQuery())
		) {	
			ps.setLong(1, id);
			ps.execute();
		} catch(SQLException e) {
			throw new DaoException("Error to delete a employee", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee findEmployee(final Long id) throws PersonNotFoundException, DaoException {
		Employee employee = new Employee();
		try (
				Connection conn = ConnectionFactory.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(
						SqlQueryEnum.EMPLOYEE_SELECT_ID.getQuery())
		) {	
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {			
				if(!rs.next()) {
					throw new PersonNotFoundException("Employee with ID " + id + " not found");
				} else {
					do {
						employee.setId(rs.getLong("emp_id"));
						employee.setName(rs.getString("emp_name"));
						employee.setEmail(rs.getString("emp_email"));
						employee.setPhone(rs.getString("emp_phone"));
						employee.setCpf(rs.getString("emp_cpf"));
						employee.setPosition(rs.getString("emp_position"));
						employee.setSalary(rs.getDouble("emp_salary"));
						employee.setModificationDate(new Date(rs.getTimestamp(
								"emp_modification_date").getTime()));
					} while (rs.next());
				}
			}
		} catch(SQLException e) {
			throw new DaoException("Error to find a employee", e);
		} 
		return employee;
	}
}
