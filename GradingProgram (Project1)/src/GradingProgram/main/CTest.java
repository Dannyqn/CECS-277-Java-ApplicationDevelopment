package GradingProgram.main;

import java.io.*;
import java.util.Scanner;

public class CTest {
	
	private int[] answerKey;
	private double classAverage;
	private int numOfStudents;
	private static int numOfQuestions;
	private int[] numOfEachMissedQuestion;
	private static final int MAX_STU = 100;
	private CStudent[] listofStudents = new CStudent[MAX_STU];
	private Scanner scan, file;
	
	
	public CTest(){
		classAverage = 0;
		numOfStudents = 0;
		numOfQuestions = 0;
		answerKey = new int[0];
	}
	public void setAnswerKey(int numofQs){
		answerKey = new int[numofQs];
		for(int i = 0; i < numOfQuestions; i++){
			answerKey[i] = file.nextInt();
		}
	}
	public void setSizeOfNumOfEachMissedQuestion(int numofQs){
		numOfEachMissedQuestion = new int[numofQs];
	}
	public static void setNumOfQuestions(int numofquestions){
		numOfQuestions = numofquestions;
	}
	public static int getNumOfQuestions(){
		return numOfQuestions;
	}
	public void calcClassAverage(){
		int total = 0;
		for(int i = 0;i<numOfStudents; i++){
			total += listofStudents[i].getTestScore();
		}
		classAverage = ((double)total/numOfStudents);
	}
	public double calcPercentageMissed(int index){
		double percentageMissed;
		percentageMissed = 100-(((double)(numOfStudents - numOfEachMissedQuestion[index])/numOfStudents)*100);
		return percentageMissed;
	}
	public void calcLetterGrades(){
		int A,B,C,D,F;
		A = B = C = D = F = 0;
		for(int i = 0; i < numOfStudents;i++){
			if(listofStudents[i].getTestScore()>= 90.0){
				A++;
			}
			else if(listofStudents[i].getTestScore()>= 80.0){
				B++;
			}
			else if(listofStudents[i].getTestScore()>= 70.0){
				C++;
			}
			else if(listofStudents[i].getTestScore()>= 60.0){
				D++;
			}
			else if(listofStudents[i].getTestScore()>= 0.00){
				F++;
			}
		}
			System.out.println("A = " + A);
			System.out.println("B = " + B);
			System.out.println("C = " + C);
			System.out.println("D = " + D);
			System.out.println("F = " + F);
	}
	public void grade(){
		
		//File input
		System.out.println("What is the file name: ");
		scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		try {
			file = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		//setting the num of questions
		setNumOfQuestions(file.nextInt());
	
		//setting the size of answerKey and NumOfEachMissedQuestion
		setAnswerKey(numOfQuestions);
		setSizeOfNumOfEachMissedQuestion(numOfQuestions);
		
		//creating new CStudents with an ID and responses
		int count = 0;
		while(file.hasNextInt()){
			listofStudents[count] = new CStudent(file,numOfQuestions);
			numOfStudents++;
			count++;
		}

		//Calculating test score and missed questions
		for(int i = 0; i < numOfStudents; i++){
			for(int j = 0; j <numOfQuestions; j++){
				if(listofStudents[i].getOneResponse(j) == answerKey[j]){
					listofStudents[i].setMissedQuestion(j, true);
				}
				else{
					listofStudents[i].setMissedQuestion(j, false);
					numOfEachMissedQuestion[j]++;
				}
			}
			listofStudents[i].calcNumOfMissed(numOfQuestions);
			listofStudents[i].calcTestScore(numOfQuestions);
		}
		
		//Table Formatting
		System.out.print("\tQUESTION\t");
		for(int i = 1; i<=getNumOfQuestions();i++){
			if(i<10){
				System.out.print("0 ");
			}
			else if(i<20){
				System.out.print("1 ");
			}
			else{
				System.out.print("2 ");
			}
		}
		System.out.println("   NUMBER");
		System.out.print("\t\t\t");
		for(int i = 1; i<=getNumOfQuestions(); i++){
			if(i%10 == 0){
				System.out.print(0 + " ");
			}
			else{
				System.out.print((i%10) + " ");
			}
		}
		System.out.println("   MISSES");
		for(int i = 0; i < (24 + getNumOfQuestions()*2) - 1; i++){
			System.out.print("=");
		}
		System.out.print("\nID\tGRADE\t   KEY> ");
		for(int i = 0; i<getNumOfQuestions(); i++){
			System.out.print(answerKey[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < (24 + getNumOfQuestions()*2) - 1; i++){
			System.out.print("=");
		}
		
		//StudentID, testScore, missedQuestions, and # of misses
		for(int i = 0; i < numOfStudents; i++){
			System.out.print("\n" + listofStudents[i].getStudentID());
			if(listofStudents[i].getTestScore() == 100.00){
				System.out.printf("%9.2f",listofStudents[i].getTestScore());
			}
			else if(listofStudents[i].getTestScore() >= 10.00){
				System.out.printf("%9.2f",listofStudents[i].getTestScore());
			}
			else{
				System.out.printf("%9.2f",listofStudents[i].getTestScore());
			}
			System.out.print("\t\t");
			for(int j = 0; j<getNumOfQuestions();j++){
				if(listofStudents[i].getMissedQuestion(j)== false ){
					System.out.print("X ");
				}
				else{
					System.out.print("  ");
				}
			}
			System.out.printf("%8d",listofStudents[i].getNumOfMissed());
		}
		
		//Question #, # of times each Question was missed, Percentage Missed
		System.out.printf("\n\n%s%11s%18s","QUESTION","TIMES","PERCENTAGE");
		System.out.printf("\n %s%13s%16s","NUMBER","MISSED","MISSED\n");
		for(int i = 0; i<39; i++){
			System.out.print("=");
		}
		for(int i = 0; i<getNumOfQuestions();i++){
			System.out.printf("\n%5d%13d%17.2f",(i+1),numOfEachMissedQuestion[i],calcPercentageMissed(i));
		}
		
		//# of exams scored
		System.out.println("\n\n"+ numOfStudents + " EXAMS SCORED\n");
		
		//Letter Grades
		calcLetterGrades();
		
		//Class Average
		calcClassAverage();
		System.out.print("\nCLASS AVERAGE  " + classAverage);
		}
	}
