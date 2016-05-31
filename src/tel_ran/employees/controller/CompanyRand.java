package tel_ran.employees.controller;

import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.dao.Manager;
import tel_ran.employees.model.dao.WageEmployee;
import tel_ran.employees.model.interfaces.IEmployeesModel;
import tel_ran.generation.events.Distribution;

public class CompanyRand {
	int nEmployees;
	int percentWageEmployees;
	int nNames;
	int minBasicSalary;
	int maxBasicSalary;
	int maxGrade;
	int minWage;
	int maxWage;
	int minHours;
	int maxHours;
	public IEmployeesModel employees;
	private int id;
	private String name;
	private String position;
	private int basicSalary;
	
	public CompanyRand(int nEmployees, int percentWageEmployees, int nNames, int minBasicSalary, int maxBasicSalary,
			int maxGrade, int minWage, int maxWage, int minHours, int maxHours, IEmployeesModel employees) {
		super();
		this.nEmployees = nEmployees;
		this.percentWageEmployees = percentWageEmployees;
		this.nNames = nNames;
		this.minBasicSalary = minBasicSalary;
		this.maxBasicSalary = maxBasicSalary;
		this.maxGrade = maxGrade;
		this.minWage = minWage;
		this.maxWage = maxWage;
		this.minHours = minHours;
		this.maxHours = maxHours;
		this.employees = employees;
	}
	public void createCompany(){
		int nWageEmployees = nEmployees*percentWageEmployees/100;
		int nManagers = nEmployees - nWageEmployees;
		for(int i = 0; i < nWageEmployees; i++){
			employees.hireEmployee(getWageEmployee());
		}
		for(int i = 0; i < nManagers; i++){
			employees.hireEmployee(getManager());
		}
	}
	private Employee getManager() {
		createEmployee();
		int grade = Distribution.getRandomNumber(1, maxGrade);
		return new Manager(id, name, position, basicSalary, grade);
	}
	private Employee getWageEmployee() {
		createEmployee();
		
		int wage = Distribution.getRandomNumber(minWage, maxWage);
		int hours = Distribution.getRandomNumber(minHours, maxHours);
		return new WageEmployee(id, name, position, basicSalary, wage, hours);
	}
	private void createEmployee() {
		id = Distribution.getRandomNumber(1, Integer.MAX_VALUE);
		basicSalary = Distribution.getRandomNumber(minBasicSalary, maxBasicSalary);
		position = "position" + Distribution.getRandomNumber(1, 5);
		name = "name" + Distribution.getRandomNumber(1, nNames);
		}
}
