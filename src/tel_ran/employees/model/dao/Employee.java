package tel_ran.employees.model.dao;

public class Employee {
	int id;
	String name;
	String position;
	int basicSalary;
	
	public Employee(int id, String name, String position, int basicSalary) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.basicSalary = basicSalary;
	}	
	public Employee(int id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", position=" + position + ", basicSalary=" + basicSalary;
	}

	public boolean equals(Object obj){
		return id == ((Employee)obj).id;
	}
	
	public int computeSalary(){
		return basicSalary; 
	}
}
