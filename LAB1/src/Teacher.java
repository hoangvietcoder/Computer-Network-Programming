
public class Teacher extends Person {
	
	public int salary;

	Teacher(String name, String code, int birthday) {
		super(name, code, birthday); //ke thua constructor cua lop Person
		this.setSalary(0); //gan gia tri mac dinh cua salary la 0
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void showInfo() {
		System.out.println("Teacher Info:............");
		super.showInfo(); //ke thua ham showInfo() cua lop Person
		System.out.println("Salary \t: " + this.getSalary()); //lay gia tri salary cua Teacher
	}

}
