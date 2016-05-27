package tel_ran.eployees.model.implementation;

import tel_ran.collections.interfaces.Predicate;
import tel_ran.employees.model.dao.Employee;

public class PredicateMinMax implements Predicate {
	public int min;
	public int max;

	@Override
	public boolean matches(Object arg) {
		int salary = ((Employee) arg).computeSalary();
		if((salary  > min) && (salary < max)) return true;
		else return false;
	}

}
