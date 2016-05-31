package tel_ran.employees.model.implementation;

import tel_ran.collections.Array;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.interfaces.IEmployeesModel;

public class EmployeesArray implements IEmployeesModel {
	Array emploees;
	
	public EmployeesArray() {
		this.emploees = new Array();
	}

	@Override
	public boolean hireEmployee(Employee empl) {
		if(emploees.indexOf(empl)==-1){
		emploees.add(empl);
		return true;
		}
		else return false;
	}

	@Override
	public boolean fireEmployee(int id) {
		Employee pattern = new Employee(id);
		int ind = emploees.indexOf(pattern);
		if (ind == -1){
			return false;
		}
		emploees.remove(ind);
		return true;
	}

	@Override
	public Array getAllEmployees() {
		Array res = new Array();
		int nElements = emploees.size();
		for(int i = 0; i < nElements; i++){
			res.add(emploees.get(i));
		}
		return res;
	}

	@Override
	public Employee getEmployee(int id) {
		return (Employee)(emploees.get(id));
	}

	@Override
	public Array getEmployeesBySalary(int minSalary, int maxSalary) {
		PredicateMinMax predicate = new PredicateMinMax(minSalary, maxSalary);
		return emploees.find(predicate);
	}
	

}
