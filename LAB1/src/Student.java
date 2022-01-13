
public class Student extends Person{
	
	public double score;

	Student(String name, String code, int birthday) {
		super(name, code, birthday); //ke thua constructor cua lop Person
		this.setScore(0.0); //gan gia tri mac dinh cua score la 0.0
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public void showInfo() {
		System.out.println("Student Info:............"); 
		super.showInfo(); //ke thua ham showInfo() cua lop Person
		System.out.println("Score \t: " + this.getScore()); //lay gia tri score cua Student
	}
	
}
