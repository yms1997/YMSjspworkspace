package gugudon;

import java.util.ArrayList;
import java.util.Random;

public class GugudanDAO {

	private int count;
	private int score;
	
	ArrayList<GugudanVO> quiz;
	
	public GugudanDAO(){
		quiz = new ArrayList<GugudanVO>();
		makeQuiz();
		count = 0;
	}
	
	private void makeQuiz() {
		Random rd = new Random();

		for(int i =0; i < 5; i+=1) {
			GugudanVO vo = new GugudanVO(rd.nextInt(8)+2,rd.nextInt(9)+1);
			quiz.add(vo);
		}
		
		System.out.println(quiz);
	}
	
	public boolean checkAnswer(String input) {
		int answer = Integer.parseInt(input);
		GugudanVO vo = quiz.get(count);
		
		if(answer == vo.getNum1()*vo.getNum2() ) {
			score+=20;
			count+=1;
			return true;
		}
		count+=1;
		return false;
	}
	
	public String getQuiz() {
		
		return quiz.get(count).toString();
	}

	public int getCount() {
		return count;
	}


	public int getScore() {
		return score;
	}

}
