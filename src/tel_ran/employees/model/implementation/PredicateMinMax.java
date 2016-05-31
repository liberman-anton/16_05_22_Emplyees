package tel_ran.employees.model.implementation;

import tel_ran.collections.interfaces.Predicate;
import tel_ran.employees.model.dao.Employee;

public class PredicateMinMax implements Predicate {
	int min;
	int max;

	public PredicateMinMax(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public boolean matches(Object arg) {
		int salary = ((Employee) arg).computeSalary();
		if((salary  >= min) && (salary <= max)) return true;
		else return false;
	}

}
