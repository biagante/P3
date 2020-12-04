package aula8;

public class Question {

	private String image;
	private String question;
	private String[] options;
	private int difficulty;
	
	public Question(String image,String question,String[] options,int diff) {
		this.image = image;
		this.question = question;
		this.options = options;
		difficulty = diff;
	}

	public String getImage() {
		return image;
	}

	public String getQuestion() {
		return question;
	}

	public String[] getOptions() {
		return options;
	}

	public int getDifficulty() {
		return difficulty;
	}
	
	public String solution() {
		return options[0];
	}
}
