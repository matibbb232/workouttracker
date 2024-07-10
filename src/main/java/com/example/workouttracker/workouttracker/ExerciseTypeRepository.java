package com.example.workouttracker.workouttracker;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseTypeRepository
        extends MongoRepository<ExerciseType, String> {

}
