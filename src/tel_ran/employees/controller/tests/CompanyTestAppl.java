package tel_ran.employees.controller.tests;

import tel_ran.collections.Array;
import tel_ran.employees.controller.CompanyRand;
import tel_ran.employees.controller.salary.CompanySalary;
import tel_ran.employees.controller.salary.SalaryGroup;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.implementation.EmployeesArray;
import tel_ran.employees.model.interfaces.IEmployeesModel;

public class CompanyTestAppl {
	public static void main(String[] args) {
		IEmployeesModel employees = new EmployeesArray();
		int nEmployees = 100;
		int percentWageEmployees = 80;
		int nNames = 20;
		int minBasicSalary = 4500;
		int maxBasicSalary = 15000;
		int maxGrade = 5;
		int minWage = 40;
		int maxWage = 150;
		int minHours = 100;
		int maxHours = 200;
		CompanyRand company = new CompanyRand(nEmployees, percentWageEmployees, nNames, minBasicSalary,
				maxBasicSalary, maxGrade, minWage, maxWage, minHours, maxHours, employees);
		company.createCompany();
		CompanySalary companySalary = new CompanySalary(company.employees);
		Array arr = companySalary.getSalaryGroups(3);
		int nGroups = arr.size();
		for(int i = 0; i < nGroups; i++){
			SalaryGroup group = (SalaryGroup)(arr.get(i));
			Array arrOfGruop = group.getEmployees();
			EmployeesArray emplArr = new EmployeesArray();
			int nArr = arrOfGruop.size();
			for(int j = 0; j < nArr ; j++){
				Object obj = arrOfGruop.get(j);
				Employee empl = (Employee)obj;
				emplArr.hireEmployee(empl);
				}
			displayCompany(emplArr);
			}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		companySalary.increaseSalary((SalaryGroup)(arr.get(0)), 10);
		companySalary.decreaseSalary((SalaryGroup)(arr.get(nGroups - 1)), 10);
		//TO-DO method display by SalaryGroup
		for(int i = 0; i < nGroups; i++){
			SalaryGroup group = (SalaryGroup)(arr.get(i));
			Array arrOfGruop = group.getEmployees();
			EmployeesArray emplArr = new EmployeesArray();
			int nArr = arrOfGruop.size();
			for(int j = 0; j < nArr ; j++){
				Object obj = arrOfGruop.get(j);
				Employee empl = (Employee)obj;
				emplArr.hireEmployee(empl);
				}
			displayCompany(emplArr);
			}
		
	}

	private static void displayCompany(IEmployeesModel employees) {
		Array allEmployees = employees.getAllEmployees();
		int nEmployees = allEmployees.size();
		for(int i = 0; i < nEmployees; i++){
			System.out.println(allEmployees.get(i));
			
		}
		System.out.println("---------------------------------------------------------");
	}
}
