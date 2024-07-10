package com.example.workouttracker.workouttracker;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class ExerciseType {
    @Id
    private String id;
    private String name;
    private List<String> tags;

    public ExerciseType(String name, List<String> tags) {
        this.name = name;
        this.tags = tags;
    }
}
