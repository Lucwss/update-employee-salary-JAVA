package entities;

import java.util.Objects;

public class Employee implements Comparable<Employee> {
	private Integer id;
	private String name;
	private Double Salary;
	
	public static Employee editEmployee;
	
	public Employee(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		Salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Salary, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(Salary, other.Salary) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Employee o) {
		return id.compareTo(o.getId());
	}
	
	
	
	
}
