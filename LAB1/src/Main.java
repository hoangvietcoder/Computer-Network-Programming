
public class Main {
	
	public static void main(String[] args) {
		//Khoi tao doi tuong student
		Student student = new Student("Mai Hoang Viet", "SV001", 2001);
		student.setScore(8.0); //gan gia tri cho thuoc tinh score
		student.showInfo(); //In ra thong tin cua student
		
		//Khoi tao doi tuong teacher
		Teacher teacher = new Teacher("Phan Phuoc Co", "T001", 1986);
		teacher.setSalary(15000000); //gan gia tri cho thuoc tinh salary
		teacher.showInfo(); //In ra thong tin cua teacher
	}
	
}
