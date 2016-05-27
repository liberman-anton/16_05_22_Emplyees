package tel_ran.employees.model.dao;

public class WageEmployee extends Employee {
	int wage;
	int hours;
	public WageEmployee(int id, String name, String position, int basicSalary, int wage, int hours) {
		super(id, name, position, basicSalary);
		this.wage = wage;
		this.hours = hours;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String toString(){
		return  "WageEmployee " + super.toString() + " wage = " + wage + ", hours = " + hours;
	}
	public int cmputeSalary(){
		return super.computeSalary() + wage * hours;
	}
}
