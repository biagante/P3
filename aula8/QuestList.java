package aula8;

import java.util.ArrayList;

public class QuestList {

	private ArrayList<Question> questionList;
	
	public QuestList() {
		questionList = new ArrayList<Question>();
	}

	public void addQuest(Question quest) {
		questionList.add(quest);
	}
	
	public int getSize() {
		return questionList.size();
	}
	
	public int getLevel() {
		return questionList.get(0).getDifficulty();
	}
	
	public ArrayList<Question> currentLevelList(){
		ArrayList<Question> q = new ArrayList<Question>();
		for(int i=0; i < questionList.size(); i++) {
			if(questionList.get(i).getDifficulty() == getLevel()) {
				q.add(questionList.get(i));
			}
		}
		return q;
	}

	public void rem(Question q) {
		questionList.remove(q);
	}
}
