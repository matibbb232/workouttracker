package com.example.workouttracker.workouttracker;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ExerciseTypeService {

    private final ExerciseTypeRepository exerciseTypeRepository;

    public List<ExerciseType> getAllWorkouts() {
        return exerciseTypeRepository.findAll();
    }
}
