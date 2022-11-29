package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import services.EmployeeServices;




public class App {
	
	public static Boolean found = false;

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		EmployeeServices service = new EmployeeServices();
		
		List<Employee> employees = new ArrayList<>();
		
		try (Scanner input = new Scanner(System.in)){
			
		System.out.print("How many employees will be registered? ");	
		Integer q = input.nextInt();
		
		for(int i = 0; i < q; i++) {
			System.out.printf("Employee #%d: %n", i+1);
			System.out.print("ID: ");
			Integer id = input.nextInt();
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Salary: ");
			Double salary = input.nextDouble();
			employees.add(new Employee(id, name, salary));
		}
		
		System.out.print("Enter the employee id that will have salary increase: ");
		Integer id = input.nextInt();
		
		Employee edit = EmployeeServices.findEmployee(employees, id);
		if(edit != null){
				System.out.print("Enter the percentage: ");
				service.increaseSalary(edit, input.nextDouble());
		}
		else System.out.println("this id does not exists!");
		
		
		showEmployees(employees);
			
		} catch (InputMismatchException e) {
			System.out.println("Input Error: " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void showEmployees(List<Employee> employees) {
		System.out.println("List of employees");
		employees.forEach(EmployeeServices::printEmployee);
	}

}
