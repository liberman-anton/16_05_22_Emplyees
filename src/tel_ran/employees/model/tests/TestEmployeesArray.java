package tel_ran.employees.model.tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import tel_ran.collections.Array;
import tel_ran.employees.model.dao.Employee;
import tel_ran.employees.model.implementation.EmployeesArray;

public class TestEmployeesArray {

	private static final int nElements = 10;
	EmployeesArray testEmplArr;

	@Before
	public void setUp() throws Exception {
		testEmplArr = new EmployeesArray();
		for(int i = 0; i < nElements; i++){
			Employee empl = new Employee(i, "name" + i, "position" + i % 5, 
					100 * (i % 5) + i * 10);
			testEmplArr.hireEmployee(empl);
		}
	}

	@Test
	public void testGetEmployeesBySalary(){
		Array arr = testEmplArr.getEmployeesBySalary(200,500);
		int size = arr.size();
		for(int i = 0; i < size; i++){
			Employee empl = (Employee)(arr.get(i));
			System.out.println(empl);
		}	
		
	}
	
	@Test
	public void testHire(){
		Employee empl = new Employee(123,"Anton","Boss",100000);
		testEmplArr.hireEmployee(empl);
		assertFalse(testEmplArr.hireEmployee(empl));
	}

}
