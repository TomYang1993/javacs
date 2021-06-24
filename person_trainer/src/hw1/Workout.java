package hw1;//Jiahui Chen
//jiahuich

public class Workout {
	int timeSpent, caloriesBurned; //as computed by the buildWorkoutPlan() method

	/**buildWorkoutPlan() method starts with the allExercises array and based on
	 * timeInput and caloriesInput values, assigns hw1.Exercise objects to a new suggestedExercises.
	 * The logic is that you make sequential pass on allExercises array and keep adding its 
	 * Exercises to suggestedExercises. If the timeInput <= 13 and caloriesInput <= 100, it will require only 
	 * one full or partial pass through allExercises. If more time or calories are needed, then continue to make more passes and 
	 * add to the hw1.Exercise objects' repTime, repCount, and calories.
	 * Return the final suggestedExercises built by the method.
	 * @return
	 */
	public Exercise[] buildWorkoutPlan(Exercise[] allExercises, int timeInput, int caloriesInput) {

		//write your code here
		Exercise[] suggestedExercises = new Exercise[allExercises.length];
		for (int i = 0; i < allExercises.length; i++) {
			suggestedExercises[i] = allExercises[i];
		}
		int pass = 1;
		while (!(timeSpent >= timeInput && caloriesBurned >= caloriesInput)) {
			for (int i = 0 ; i < allExercises.length; i++) {
				if (!(timeSpent >= timeInput && caloriesBurned >= caloriesInput)){
					timeSpent += allExercises[i].repTime;
					caloriesBurned += allExercises[i].calories;
					suggestedExercises[i].repTime = allExercises[i].repTime * pass;
					suggestedExercises[i].repCount = allExercises[i].repCount * pass;
					suggestedExercises[i].calories = allExercises[i].calories * pass;
				}
			}
			pass++;
		}
		return suggestedExercises;
	}
}
