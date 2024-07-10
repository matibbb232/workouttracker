package com.example.workouttracker.workouttracker;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/exercise_types")
@AllArgsConstructor
public class ExerciseTypeController {

    private final ExerciseTypeService exerciseTypeService;

    @GetMapping
    public List<ExerciseType> fetchAllWorkouts() {
        return exerciseTypeService.getAllWorkouts();
    }
}
