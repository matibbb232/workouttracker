package com.example.workouttracker.workouttracker;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ExerciseSet {
    @Id
    private String id;
    private ExerciseType exercise;
    private Integer reps;
    private Double weight;

    public ExerciseSet(ExerciseType exercise, Integer reps, Double weight) {
        this.exercise = exercise;
        this.reps = reps;
        this.weight = weight;
    }
}
