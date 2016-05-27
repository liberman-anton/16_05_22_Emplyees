package tel_ran.eployees.model.tests;

import org.junit.Before;
import org.junit.Test;

import tel_ran.collections.Array;
import tel_ran.employees.model.dao.Employee;
import tel_ran.eployees.model.implementation.EmployeesArray;

public class TestEmployeesArray {

	private static final int nElements = 10;
	//EmployeesArray testEmplArr;

	@Before
	public void setUp() throws Exception {
		EmployeesArray testEmplArr = new EmployeesArray();
		for(int i = 0; i < nElements; i++){
			Employee empl = new Employee(i, "name" + i, "position" + i % 5, 
					100 * (i % 5) + i * 10);
			testEmplArr.hireEmployee(empl);
		}
	}

	@Test
	public void testGetEmployeesBySalary(){
		EmployeesArray testArr = new EmployeesArray();
		for(int i = 0; i < nElements; i++){
			Employee empl = new Employee(i, "name" + i, "position" + i % 5, 
					100 * (i % 5) + i * 10);
			testArr.hireEmployee(empl);
		}
		Array arr = testArr.getEmployeesBySalary(300,500);
		int size = arr.size();
		for(int i = 0; i < size; i++){
			Employee empl = (Employee)(arr.get(i));
			System.out.println(empl);
		}	
		
	}

}
