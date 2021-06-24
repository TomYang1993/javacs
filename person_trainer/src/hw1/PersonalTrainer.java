package hw1;//Jiahui Chen
//jiahuich

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PersonalTrainer {
	
	static final String EXERCISE_DATA_FILE = "data/MasterExercises1.csv";
	
	Exercise[] masterExercises;		//loads all exercises from the master data file
	Exercise[] selectedExercises;	//has the proposed exercise plan based on user input
	int timeInput, caloriesInput;  	//stores user inputs
	Scanner input;  				//use this for file and keyboard I/O
	
	//Do not change this method
	public static void main(String[] args) {
		PersonalTrainer personalTrainer = new PersonalTrainer();
		personalTrainer.loadExercises();
		personalTrainer.getUserInputs();
		Workout workout = new Workout();
		personalTrainer.selectedExercises = workout.buildWorkoutPlan(personalTrainer.masterExercises, personalTrainer.timeInput, personalTrainer.caloriesInput);
		personalTrainer.printWorkoutPlan();
	}
	
	/** loadExercises() method reads EXERCISE_DATA_FILE and loads allExercises array
	 * with hw1.Exercise objects where each object stores data in one row of
	 * EXERCISE_DATA_FILE
	 */
	void loadExercises() {
		//write your code here
		File file = new File("MasterExercises1.csv");
		StringBuilder fileContent = new StringBuilder();
		try {
			input = new Scanner(file);
			while (input.hasNextLine()){
				fileContent.append(input.nextLine()+"\n");
			}
			String[] rows = fileContent.toString().split("\n");
			masterExercises = new Exercise[rows.length];
			int count = 0;
			for (String row : rows) {
				String name = row.split(",")[0].trim();
				String level = row.split(",")[1].trim();
				int repTime = Integer.parseInt(row.split(",")[2].trim());
				int repCount = Integer.parseInt(row.split(",")[3].trim());
				int calories = Integer.parseInt(row.split(",")[4].trim());
				String exerciseNotes = row.split(",")[5].trim();
				masterExercises[count++] = new Exercise(name, level, repTime,repCount,calories,exerciseNotes);
			}
			masterExercises = Arrays.copyOf(masterExercises, count);
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/** getUserInputs() method asks user for two inputs: timeInput and caloriesInput. 
	 * It initializes the member variables with the values input by the user
	 */
	private void getUserInputs() {
		//write your code here
		System.out.println("How much time (in minutes) do you have for today's workout?");
		input = new Scanner(System.in);
		timeInput = input.nextInt();
		System.out.println("Target calories to burn?");
		caloriesInput = input.nextInt();
	}
	
	/** printWorkoutPlan() method takes the hw1.Workout object initialized
	 * in the main method and prints the output as shown in the HW1 handout. 
	 * @param
	 */
	private void printWorkoutPlan() {
		//write your code here
		if (selectedExercises == null){
			System.out.println("Sorry! No workout plan can be suggested!");
		}

		System.out.println("------------------------------------------------------------------------------");
		System.out.println("hw1.Exercise\t\tLevel\t\tTime(min)\t\tReps\t\tCalories\t\t\tNotes");
		System.out.println("------------------------------------------------------------------------------");

		int totalTime = 0;
		int totalCal = 0;
		for (Exercise ex : selectedExercises){
			System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", ex.name,ex.level, ex.repTime, ex.repCount, ex.calories, ex.exerciseNotes);
			totalTime += ex.repTime;
			totalCal += ex.calories;
		}
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("This workout will take about " + totalTime + " and will burn approximately "+totalCal+" calories");
	}
}
