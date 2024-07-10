package com.example.workouttracker.workouttracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Criteria;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootApplication
public class WorkouttrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkouttrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ExerciseTypeRepository exercise_repository, WorkoutRepository workout_repository, MongoTemplate mongoTemplate) {
		return args -> {

			// Check if item is already in db using Query
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is("bench press"));
			List<ExerciseType> exerciseTypes = mongoTemplate.find(query, ExerciseType.class);

			// Adds sample exercise type
			ExerciseType exercise = new ExerciseType("bench press",
					List.of("upper body", "chest"));
			if (exerciseTypes.isEmpty()) {
				exercise_repository.insert(exercise);
			}


			// Checks if was added successfully
			exerciseTypes = mongoTemplate.find(query, ExerciseType.class);
			if (exerciseTypes.size() == 1) {
				System.out.println("Item correctly added");
			}

			// Adding sample workout
			exercise = exerciseTypes.get(0);
			ExerciseSet set1 = new ExerciseSet(exercise, 10, 97.5);
			ExerciseSet set2 = new ExerciseSet(exercise, 6, 107.5);
			Workout workout = new Workout(
					LocalDateTime.now(),
					List.of(set1, set2),
					""
			);
			workout_repository.insert(workout);
		};
	}
}
