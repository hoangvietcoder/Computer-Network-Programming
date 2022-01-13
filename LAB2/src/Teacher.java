
public class Teacher extends Person {
	
	public int salary;

	Teacher(String name, String code, int birthday, int salary) {
		super(name, code, birthday); 
		this.setSalary(salary); 
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
