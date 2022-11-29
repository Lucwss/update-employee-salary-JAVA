package services;

import java.util.List;

import entities.Employee;
import interfaces.IncreaseSalary;

public class EmployeeServices implements IncreaseSalary {

	@Override
	public void increaseSalary(Employee emp, Double percentage) {
		emp.setSalary(emp.getSalary() + (emp.getSalary() * (percentage / 100)));
	}
	
	public static void printEmployee(Employee emp) {
		System.out.println(emp.getId() + ", " + emp.getName() +  ", " + String.format("%.2f", emp.getSalary()));
	}
	
	public static Employee findEmployee(List<Employee> emps, Integer id) {
		emps.forEach(x -> {
			if(x.getId().equals(id)) {
				Employee.editEmployee = x;
			}
		});
		return Employee.editEmployee;
	}
	
}
