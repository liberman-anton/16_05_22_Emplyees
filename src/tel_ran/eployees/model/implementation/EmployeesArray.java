package tel_ran.eployees.model.implementation;

import tel_ran.collections.Array;
import tel_ran.employees.model.dao.Employee;
import tel_ran.eployees.model.interfaces.IEployeesModel;

public class EmployeesArray implements IEployeesModel {
	public Array emploees;
	
	public EmployeesArray() {
		this.emploees = new Array();
	}

	@Override
	public boolean hireEmployee(Employee empl) {
		int sizeOld = emploees.size();
		emploees.add(empl);
		if(sizeOld + 1 == emploees.size()) return true;
		else return false;
	}

	@Override
	public boolean fireEmployee(int id) {
		int sizeOld = emploees.size();
		emploees.remove(id);
		if(sizeOld - 1 == emploees.size()) return true;
		else return false;
	}

	@Override
	public Array getAllEmployees() {
		return emploees;
	}

	@Override
	public Employee getEmployee(int id) {
		return (Employee)(emploees.get(id));
	}

	@Override
	public Array getEmployeesBySalary(int minSalary, int maxSalary) {
		PredicateMinMax predicate = new PredicateMinMax();
		predicate.min = minSalary;
		predicate.max = maxSalary;
		return emploees.find(predicate);
	}
	

}
