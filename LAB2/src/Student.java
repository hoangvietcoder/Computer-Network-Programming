
public class Student extends Person{
	
	public double score;

	Student(String name, String code, int birthday, double score) {
		super(name, code, birthday); 
		this.setScore(score); 
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
