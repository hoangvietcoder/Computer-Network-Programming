import java.util.Calendar;

public class Person {
	
	public String name;
	public String code;
	public int birthday;
	
	Person(String name, String code, int birthday){
		this.name = name;
		this.code = code;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
	public int getAge() {
		Calendar calendar = Calendar.getInstance(); //tao doi tuong Calendar
		return calendar.get(Calendar.YEAR) - this.getBirthday(); //Lay so nam hien tai tru so nam sin ra
	}
	
	public void showInfo() {
		System.out.println("Name \t: " + this.getName()); //lay gia tri name cua Person
		System.out.println("Code \t: " + this.getCode()); //lay gia tri code cua Person
		System.out.println("Birthday: " + this.getBirthday()); //lay gia tri birthday cua Person
		System.out.println("Age \t: " + this.getAge()); //lay gia tri age cua Person
	}
	
}
