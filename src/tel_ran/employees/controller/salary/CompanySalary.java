package tel_ran.employees.controller.salary;

import tel_ran.collections.Array;
import tel_ran.collections.interfaces.Comparator;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.interfaces.IEmployeesModel;

public class CompanySalary {
	private IEmployeesModel emploees;
	
	public CompanySalary(IEmployeesModel emploees) {
		super();
		this.emploees = emploees;
	}

	// returns array of employees sorted by salary
	public Array getEmployeesSortedBySalary(){
		Array res = new Array();
		int nElements = emploees.getAllEmployees().size();
		for(int i = 0; i < nElements; i++){
			res.add((Employee)emploees.getAllEmployees().get(i));
		}
		res.sort(new Comparator() {
			public int compare(Object obj1, Object obj2) {
				return ((Employee)obj1).computeSalary() - ((Employee)obj2).computeSalary();
				}
			});
		return res;
	}
	
	// returns array of salary group
	public Array getSalaryGroups(int nGroups){
		Array arr = this.getEmployeesSortedBySalary();
		Array res = new Array();
		int nElements = arr.size();
		int nElementsInGroup = nElements / nGroups;
		int remainder = nElements % nGroups;
		int i = 0;
		while(i < nElements){
			Employee empl = (Employee)(arr.get(i));
			int minSalary = empl.computeSalary();
			Array emplGroup = new Array();
			int j = 0;
			while(j < nElementsInGroup){
				Employee em = (Employee)arr.get(i);
				emplGroup.add(em);
				j++;
				i++;
			}
			if(remainder != 0){
				Object empPluse = (Employee)arr.get(i);
				emplGroup.add(empPluse);
				i++;
				remainder--;
			}
			empl = (Employee)(arr.get(i - 1));
			int maxSalary = empl.computeSalary();
			SalaryGroup salaryGroup = new SalaryGroup(minSalary, maxSalary, emplGroup);
			res.add(salaryGroup);
		}
		
		return res;
	}
	
	// increase basicSalary
	public void increaseSalary(SalaryGroup group, int percent){
		Array arr = group.getEmployees();
		int nElem = arr.size();
		for(int i = 0; i < nElem; i++){
			Employee emp = (Employee)(arr.get(i));
			float basicSalary = (emp.getBasicSalary()) * (1 + ((float)percent / 100));
			emp.setBasicSalary((int)basicSalary);
		}
		Employee emp = (Employee)arr.get(0);
		int minSalary = ((Employee) emp).computeSalary();
		group.setMinSalary(minSalary);
		emp = (Employee)arr.get(nElem - 1);
		int maxSalary = ((Employee) emp).computeSalary();
		group.setMaxSalary(maxSalary);
	}
	
	// decrease basicSalary
	public void decreaseSalary(SalaryGroup group, int percent){
		Array arr = group.getEmployees();
		int nElem = arr.size();
		for(int i = 0; i < nElem; i++){
			Employee emp = (Employee)(arr.get(i));
			float basicSalary = (emp.getBasicSalary()) * (1 - ((float)percent / 100));
			emp.setBasicSalary((int)basicSalary);
		}
		Employee emp = (Employee)arr.get(0);
		int minSalary = ((Employee) emp).computeSalary();
		group.setMinSalary(minSalary);
		emp = (Employee)arr.get(nElem - 1);
		int maxSalary = ((Employee) emp).computeSalary();
		group.setMaxSalary(maxSalary);		
	}
}
