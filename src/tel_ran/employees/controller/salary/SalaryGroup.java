package tel_ran.employees.controller.salary;

import tel_ran.collections.Array;

public class SalaryGroup {
	private int minSalary;
	private int maxSalary;
	private Array employees;
	public SalaryGroup(int minSalary, int maxSalary, Array employees) {
		super();
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employees = employees;
	}
	public int getMinSalary() {
		return minSalary;
	}
	public int getMaxSalary() {
		return maxSalary;
	}
	public Array getEmployees() {
		return employees;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	public void setEmployees(Array employees) {
		this.employees = employees;
	}
	
	
}
