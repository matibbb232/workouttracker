package com.example.workouttracker.workouttracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class WorkouttrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkouttrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(WorkoutRepository repository) {
		return args -> {
			ExerciseType exercise = new ExerciseType("bench press",
					List.of("upper body", "chest") );
			ExerciseSet set1 = new ExerciseSet(exercise, 10, 97.5);
			ExerciseSet set2 = new ExerciseSet(exercise, 6, 107.5);
			Workout workout = new Workout(
					LocalDateTime.now(),
					List.of(set1, set2),
					""
			);
			repository.insert(workout);
		};
	}
}
