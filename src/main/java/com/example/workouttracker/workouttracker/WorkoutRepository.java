package com.example.workouttracker.workouttracker;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkoutRepository
        extends MongoRepository<Workout, String> {

}
