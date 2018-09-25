package GradingProgram.main;

import java.util.Scanner;

public class CStudent {
	
	private int StudentID;
	private int[] responses;
	private int numofMissed;
	private boolean[] missedQuestions;
	private double testScore;
	
	public CStudent(Scanner s, int numOfQuestions){
		responses = new int[numOfQuestions];
		missedQuestions = new boolean[numOfQuestions];
		StudentID = s.nextInt();
		for(int i = 0; i < numOfQuestions; i++){
			responses[i] = s.nextInt();
		}
	}
	public void setStudentID(int ID){
		StudentID = ID;
	}
	public void setMissedQuestion(int index, boolean answer){
		missedQuestions[index] = answer;
	}
	public int getStudentID(){
		return StudentID;
	}
	public int getNumOfMissed(){
		return numofMissed;
	}
	public double getTestScore(){
		return testScore;
	}
	public boolean getMissedQuestion(int index){
		return missedQuestions[index];
	}
	public int getOneResponse(int index){
		return responses[index];
	}
	public void calcTestScore(int numofQs){
		testScore = ((double)(numofQs-numofMissed)/numofQs) * 100;
	}
	public void calcNumOfMissed(int numofQs){
		for(int i = 0; i < numofQs; i++){
			if(missedQuestions[i] == false){
				numofMissed++;
			}
		}
	}
}
