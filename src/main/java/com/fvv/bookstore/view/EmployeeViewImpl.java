package com.fvv.bookstore.view;

import java.time.YearMonth;
import java.util.List;

import javax.swing.JOptionPane;

import com.fvv.bookstore.bean.Employee;
import com.fvv.bookstore.controller.EmployeeController;
import com.fvv.bookstore.controller.EmployeeControllerImpl;
import com.fvv.bookstore.exception.ControllerException;
import com.fvv.bookstore.exception.person.PersonNotFoundException;
import com.fvv.bookstore.exception.person.PersonValidationException;
import com.fvv.bookstore.util.Constants;
import com.fvv.bookstore.util.PropertiesUtil;
import com.fvv.bookstore.util.MathUtil;

/**
 * EmployeeView class to view the Employee object.
 * 
 * @author Fatima Vasquez
 * <p>Created on 2018</p>
 * @version 1.0 	
 *
 */
public class EmployeeViewImpl implements EmployeeView {

	private final EmployeeController employeeController;
	
	/**
	 * Class constructor instantiating a new EmployeeControllerImpl object.
	 */
	public EmployeeViewImpl() {
		this.employeeController = new EmployeeControllerImpl();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addEmployee() {
		try {
			final Employee employee = this.createEmployeeFromInput(Boolean.FALSE);
			this.employeeController.addEmployee(employee);
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("employeeAdd"));	
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("problemsToConvert") + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | PersonNotFoundException | PersonValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listEmployees() {
		try {
			StringBuilder sb = new StringBuilder();
			List<Employee> employees = this.employeeController.listEmployees();
			if(employees != null && !employees.isEmpty()) {
				for(Employee c : employees) {
					sb.append(c).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing All Employees", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, PropertiesUtil.get("noItems"));
			}			
		} catch (ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEmployee() {
		try {
			final Employee employee = this.createEmployeeFromInput(Boolean.TRUE);
			this.employeeController.updateEmployee(employee);
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("employeeUpdated"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("problemsToConvert") + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ControllerException | PersonNotFoundException | PersonValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeEmployee() {
		try {
			Long idDelete = (Long.parseLong(JOptionPane.showInputDialog("Insert the ID to delete")));
			this.employeeController.findEmployee(idDelete);
			this.employeeController.removeEmployee(idDelete);
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("deletedOk"));			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, PropertiesUtil.get("problemsToConvert") + Constants.LINE_SEPARATOR 
					+ e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} catch (PersonNotFoundException | ControllerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void listEmployeesByName() {
		try {
			StringBuilder sb = new StringBuilder();
			String searchName = JOptionPane.showInputDialog("Insert a name to find");
			List<Employee> employees = this.employeeController.listEmployeesByName(searchName);
			if(employees != null && !employees.isEmpty()) {
				for(Employee emp : employees) {
					sb.append(emp).append(Constants.LINE_SEPARATOR);
				}
				JOptionPane.showMessageDialog(null, sb.toString(), "Listing the Employees", 
						JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "There are no items to show!");
			}			
		} catch (ControllerException | PersonNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void getSalaryWithCommission() {
		try {
			Long searchId = Long.parseLong(JOptionPane.showInputDialog("Insert the employee ID"));
			Employee employee = this.employeeController.findEmployee(searchId);
			employee.setId(searchId);
			final YearMonth date = YearMonth.parse(JOptionPane.showInputDialog("Insert the date (yyyy-mm)"));
			final Double percentage = Double.parseDouble(JOptionPane.showInputDialog("Input the commission percentage"));
			final Double commission = this.employeeController.calculateCommission(percentage, employee, date);
			final Double newSalary = this.employeeController.getSalaryWithCommission(commission, employee);
			JOptionPane.showMessageDialog(null, "Month: " + date.getMonth() + Constants.LINE_SEPARATOR + "ID: " + employee.getId() 
					+ Constants.LINE_SEPARATOR + "Name: " + employee.getName() + Constants.LINE_SEPARATOR + "Current Salary: " 
					+ MathUtil.formatNumbers(employee.getSalary()) + Constants.LINE_SEPARATOR + "Commission Earned: " + MathUtil.formatNumbers(commission) 
					+ Constants.LINE_SEPARATOR + "Total Salary: " + MathUtil.formatNumbers(newSalary));
		} catch (ControllerException | PersonNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private Employee createEmployeeFromInput(final boolean isUpdate) 
			throws PersonNotFoundException, ControllerException {
		final Employee employee = new Employee();
		
		if(isUpdate) {
			Long idUp = Long.parseLong(JOptionPane.showInputDialog("Insert the ID to update"));
			this.employeeController.findEmployee(idUp);
			employee.setId(idUp);
		}
		
		employee.setName(JOptionPane.showInputDialog("Insert the full name"));
		employee.setEmail(JOptionPane.showInputDialog("Insert the email"));
		employee.setPhone(JOptionPane.showInputDialog("Insert the phone"));
		employee.setCpf(JOptionPane.showInputDialog("Insert the CPF"));
		employee.setPosition(JOptionPane.showInputDialog("Insert the position"));
		employee.setSalary(Double.parseDouble(JOptionPane.showInputDialog("Insert the salary")));
		return employee;
	}
}
