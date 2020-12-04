package aula8;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;


// extends JFrame? <- check what do
public class QuizWindow implements ActionListener{

	private JLabel image = new JLabel();
	private JLabel money = new JLabel("0€");
	
	private JButton buttonQuit;
	private JButton buttonConfirm;
	
	private JButton publico;
	private JButton telefone;
	private JButton button5050;
	
	private JTextArea questionText = new JTextArea();
	
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton optionA, optionB,optionC,optionD;
	
	private int prize[] = {0,25,50,125,250,500,750,1500,2500,5000,10000,16000,32000,64000,125000,250000};
	
	private QuestList questionList = new QuestList();
	private  Question currentQuestion;
	private int questionsAnswered;

	public QuizWindow(){
	
		JFrame f = new JFrame("Quem Quer Ser Milionário");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(660, 450);
		
		JPanel quiz = new JPanel();
		quiz.setSize(660, 450);
		
		QuestionFileReader();
	    quiz.setLayout(new MigLayout("", "[1px][11px][95px][73px][][59px][77px][79px][77px][77px][67px]", "[21px][][21px][][][][][]"));
		
	    
	    quiz.add(image, "cell 0 0 4 4,alignx left,aligny center");
		
		f.setContentPane(quiz);
		quiz.add(money, "cell 5 0,alignx right,aligny center");
		
		publico = new JButton("Ajuda Publico");
		publico.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				helpPublico();
			}
		});
		
			    questionText = new JTextArea();
			    questionText.setBackground(new Color(240, 240, 240));
			    questionText.setColumns(15);
			    questionText.setEditable(false);
			    questionText.setFont(new Font("Trebuchet MS", 0, 24));
			    questionText.setLineWrap(true);
			    questionText.setRows(5);
			    questionText.setWrapStyleWord(true);
			    questionText.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
			    quiz.add(questionText, "cell 4 1 2 3,growx,aligny center");
		
		quiz.add(publico, "cell 2 4,growx,aligny top");
		
		telefone = new JButton("Telefone ...");
		telefone.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				helpTelefone();
			}
		});
		quiz.add(telefone, "cell 3 4,growx,aligny top");
		
		button5050 = new JButton("50-50");
		button5050.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				help5050();
			}
		});
		quiz.add(button5050, "cell 4 4,growx,aligny top");
		
		optionA = new JRadioButton("OptionA");
		buttonGroup.add(optionA);
		
		quiz.add(optionA, "cell 2 5,alignx left,aligny top");
		optionB = new JRadioButton("OptionB");
		buttonGroup.add(optionB);
		quiz.add(optionB, "cell 3 5,alignx left,aligny top");
		optionC = new JRadioButton("OptionC");
		buttonGroup.add(optionC);
		quiz.add(optionC, "cell 2 6,alignx left,aligny top");
		optionD = new JRadioButton("OptionD");
		buttonGroup.add(optionD);
		quiz.add(optionD, "cell 3 6,alignx left,aligny top");	
		
		buttonQuit = new JButton("Desistir");
		buttonQuit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getPrize();
			}
		});
		
		quiz.add(buttonQuit, "flowx,cell 5 6,alignx left,aligny top");
		
		buttonConfirm = new JButton("Confirmar");
		buttonConfirm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CheckAnswer(selectedButtonText());
				
				loadNextQuestion();
			}
		});
		quiz.add(buttonConfirm, "cell 5 6,alignx left,aligny top");
		f.setVisible(true);
		
		loadNextQuestion();
	}
	

	private void getPrize() {
		JOptionPane.showMessageDialog(null,"Ganhou " + prize[questionsAnswered] + "€");
		System.exit(0);
	}

	public void QuestionFileReader(){
		
		try { 
			Path path = Paths.get("src/aula8/questions.txt");
			List<String> questionLines = Files.readAllLines(path);
			
			for(String line : questionLines) {
				String[] lineSplit = line.split("&&");
				String[] imgSplit = lineSplit[0].split(":");
				Question quest = new Question(imgSplit[1],lineSplit[1],
						new String[]{lineSplit[2],lineSplit[3],lineSplit[4],lineSplit[5]},
						Integer.parseInt(lineSplit[6]));
				questionList.addQuest(quest);
			}
			
		} catch (IOException e) {
			System.out.println("Question File is not Compatible");
			System.exit(1);
		}
	}
	
	public void loadNextQuestion() {
		if(questionList.getSize() == 0) {
			getPrize();
		}
		enableAllButtons();
		ArrayList<Question> qList = questionList.currentLevelList();
		Question q = qList.get((int) (Math.random()*qList.size()));
		questionText.setText(q.getQuestion());
		money.setText(prize[questionsAnswered]+"€");
		money.setFont(new Font("Trebuchet MS", 0, 16));
		image.setIcon(new ImageIcon(new ImageIcon("src/aula8/" + q.getImage()).getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT)));
		
		String[] options = q.getOptions();
		List<Integer> randomIndexes = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			randomIndexes.add(i);
		}
		Collections.shuffle(randomIndexes);
		optionA.setText(options[randomIndexes.get(0)]);
		optionB.setText(options[randomIndexes.get(1)]);
		optionC.setText(options[randomIndexes.get(2)]);
		optionD.setText(options[randomIndexes.get(3)]);
		currentQuestion = q;
		questionList.rem(q);
		
	}
	
	public void CheckAnswer(String answer) {
		if(answer == null) {
			return;
		}
		String solution = currentQuestion.getOptions()[0];
		
		if(answer.equals(solution)) {
			questionsAnswered++;
			buttonGroup.clearSelection();	
		}else {
			getPrize();
		}
		
	}
	
	private String selectedButtonText() {
		if(optionA.isSelected()) return optionA.getText();
		else if(optionB.isSelected()) return optionB.getText();
		else if(optionC.isSelected()) return optionC.getText();
		else if(optionD.isSelected()) return optionD.getText();
		else return null;
	}
	
	public void help5050(){
		String solution = currentQuestion.solution();
		int other = (int) (Math.random()*3 + 1);
		
		if(!optionA.getText().equals(solution) && !optionA.getText().equals(currentQuestion.getOptions()[other])) {
			optionA.setEnabled(false);
		}
		if(!optionB.getText().equals(solution) && !optionB.getText().equals(currentQuestion.getOptions()[other])) {
			optionB.setEnabled(false);
		}
		if(!optionC.getText().equals(solution) && !optionC.getText().equals(currentQuestion.getOptions()[other])) {
			optionC.setEnabled(false);
		}
		if(!optionD.getText().equals(solution) && !optionD.getText().equals(currentQuestion.getOptions()[other])) {
			optionD.setEnabled(false);
		}
		button5050.setEnabled(false);
	}
	
	protected void helpTelefone() {
		int min = -1;
		int max = -1;
		if(questionList.getLevel()==0) {
			max = 100;
			min = 80;
		}else if(questionList.getLevel()==1) {
			max = 80;
			min = 60;
		}else if(questionList.getLevel()==2) {
			max = 60;
			min = 40;
		}
		String s = "Dúvida entre:\n";
		int correctChance = min + (int)(Math.random() * (max - min));
		int randIndex =(int)(Math.random()*3) + 1;
		
		s += currentQuestion.getOptions()[0]+": "+correctChance+"%\n";
		s += currentQuestion.getOptions()[randIndex]+": "+(100-correctChance)+"%";
		
		JOptionPane.showMessageDialog(null,s,"Ajuda Telefone", JOptionPane.INFORMATION_MESSAGE);
		telefone.setEnabled(false);
		
	}
	
	public void helpPublico(){
		int min = -1,max = -1;
		
		if(questionList.getLevel()== 0) {
			max = 93;
			min = 72;
		}else if(questionList.getLevel() == 1) {
			max = 70;
			min = 53;
		}else if(questionList.getLevel() == 2) {
			max = 51;
			min = 37;
		}
		
		Enumeration<AbstractButton> elements = buttonGroup.getElements();
		List<String> options = new ArrayList<String>();
		while(elements.hasMoreElements()){
			options.add(elements.nextElement().getText());
		}
		Collections.shuffle(options);
		
		String s = "";
		int solutionIndex = -1;
		
		for(int i = 0; i < 4; i++) {
			if(options.get(i).equals(currentQuestion.solution())) solutionIndex = i;
		}

		int correctChance = (int) (min + Math.random()*(max - min));
		max = 100-correctChance;
		min = 0;
		
		int counter = 0;
		for(int i = 0; i < 4; i++){
			if(i == solutionIndex) {
				s += options.get(i)+": "+correctChance+"%\n";
				continue;
			}
			if(counter >= 2) {
				s += options.get(i)+": "+max+"%\n";
				continue;
			}
			int prob = min + (int)(Math.random() * (max - min + 1));
			s += options.get(i)+": "+prob+"%\n";
			max = max - prob;
			counter++;	
		}
		JOptionPane.showMessageDialog(null,s,"Ajuda Publico", JOptionPane.INFORMATION_MESSAGE);
		publico.setEnabled(false);
	}
	
	
	private void enableAllButtons() {
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		while(buttons.hasMoreElements()) {
			buttons.nextElement().setEnabled(true);;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
