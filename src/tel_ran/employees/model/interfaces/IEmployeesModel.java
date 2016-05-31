package tel_ran.employees.model.interfaces;

import tel_ran.collections.Array;
import tel_ran.employees.model.dao.Employee;

public interface IEmployeesModel {
	public boolean hireEmployee(Employee empl);
	public boolean fireEmployee(int id);
	public Array getAllEmployees();
	public Employee getEmployee(int id);
	public Array getEmployeesBySalary(int minSalary, int maxSalary);

}
