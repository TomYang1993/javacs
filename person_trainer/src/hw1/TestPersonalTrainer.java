package hw1;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPersonalTrainer {
	
	static PersonalTrainer personalTrainer;
	static Workout workout;
	
	@BeforeClass
	public static void setupBeforeClass() {
		personalTrainer = new PersonalTrainer();
		personalTrainer.loadExercises();
		workout = new Workout();
	}

	@Test
	public void test1_AllExercisesLength() {
		assertEquals("Test count of exercises", 7, personalTrainer.masterExercises.length);
	}
	
	@Test
	public void test2_AllExercisesSequence() {
		assertEquals("Index-0", "Crunches", personalTrainer.masterExercises[0].name);
		assertEquals("Index-1", "Plank", personalTrainer.masterExercises[1].name);
		assertEquals("Index-2", "Spin", personalTrainer.masterExercises[2].name);
		assertEquals("Index-3", "Bicep-curls", personalTrainer.masterExercises[3].name);
		assertEquals("Index-4", "Squats", personalTrainer.masterExercises[4].name);
		assertEquals("Index-5", "Crunches", personalTrainer.masterExercises[5].name);
		assertEquals("Index-6", "Squats", personalTrainer.masterExercises[6].name);
	}

	@Test
	public void test3_BuildWorkoutPlanExactTimeCalories() {
		workout.timeSpent = 0;
		workout.caloriesBurned = 0;
		workout.buildWorkoutPlan(personalTrainer.masterExercises, 13, 100);
		Assert.assertEquals("Test less time", 13, workout.timeSpent);
		Assert.assertEquals("Test all calories", 100, workout.caloriesBurned);
	}
	@Test
	public void test4_BuildWorkoutPlanLessTimeAllCalories() {
		workout.timeSpent = 0;
		workout.caloriesBurned = 0;
		workout.buildWorkoutPlan(personalTrainer.masterExercises, 10, 100);
		Assert.assertEquals("Test less time", 13, workout.timeSpent);
		Assert.assertEquals("Test all calories", 100, workout.caloriesBurned);
	}
	
	@Test
	public void test5_BuildWorkoutPlanMoreTimeLessCalories() {
		workout.timeSpent = 0;
		workout.caloriesBurned = 0;
		workout.buildWorkoutPlan(personalTrainer.masterExercises, 20, 50);
		Assert.assertEquals("Test more time", 20, workout.timeSpent);
		Assert.assertEquals("Test less calories", 135, workout.caloriesBurned);
	}
	
	@Test
	public void test6_BuildWorkoutPlanLessTimeMoreCalories() {
		workout.timeSpent = 0;
		workout.caloriesBurned = 0;
		workout.buildWorkoutPlan(personalTrainer.masterExercises, 10, 150);
		Assert.assertEquals("Test less time", 22, workout.timeSpent);
		Assert.assertEquals("Test more calories", 160, workout.caloriesBurned);
	}
	
	@Test
	public void test7_BuildWorkoutPlanMoreTimeMoreCalories() {
		workout.timeSpent = 0;
		workout.caloriesBurned = 0;
		workout.buildWorkoutPlan(personalTrainer.masterExercises, 75, 400);
		Assert.assertEquals("Test more time", 76, workout.timeSpent);
		Assert.assertEquals("Test more calories", 580, workout.caloriesBurned);
	}
	
	@Test
	public void test8_BuildWorkoutPlanIgnoreTime() {
		workout.timeSpent = 0;
		workout.caloriesBurned = 0;
		workout.buildWorkoutPlan(personalTrainer.masterExercises, 0, 200);
		Assert.assertEquals("Test zero time", 26, workout.timeSpent);
		Assert.assertEquals("Test non-zero calories", 200, workout.caloriesBurned);
	}
	
	@Test
	public void test9_BuildWorkoutPlanIgnoreCalories() {
		workout.timeSpent = 0;
		workout.caloriesBurned = 0;
		workout.buildWorkoutPlan(personalTrainer.masterExercises, 20, 0);
		Assert.assertEquals("Test non-zero time", 20, workout.timeSpent);
		Assert.assertEquals("Test zero calories", 135, workout.caloriesBurned);
	}
	
	@Test
	public void test10_BuildWorkoutPlanNoTimeNoCalories() {
		workout.timeSpent = 0;
		workout.caloriesBurned = 0;
		workout.buildWorkoutPlan(personalTrainer.masterExercises, 0, 0);
		Assert.assertEquals("Test less time", 0, workout.timeSpent);
		Assert.assertEquals("Test less calories", 0, workout.caloriesBurned);
	}
	
	@Test
	public void test11_BuildWorkoutPlanLessTimeLessCalories() {
		workout.timeSpent = 0;
		workout.caloriesBurned = 0;
		workout.buildWorkoutPlan(personalTrainer.masterExercises, 10, 80);
		Assert.assertEquals("Test less time", 11, workout.timeSpent);
		Assert.assertEquals("Test less calories", 80, workout.caloriesBurned);
	}
}
