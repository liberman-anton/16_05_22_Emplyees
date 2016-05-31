package tel_ran.employees.model.dao;

public class Manager extends Employee {
	int grade;

	public Manager(int id, String name, String position, int basicSalary, int grade) {
		super(id, name, position, basicSalary);
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Manager" + super.toString() + ", grade=" + grade;
	}
	@Override
	public int computeSalary(){
		return super.computeSalary() * grade;
	}
	
}
