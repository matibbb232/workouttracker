package com.example.workouttracker.workouttracker;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "exercise_types")
public class ExerciseType {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private List<String> tags;

    public ExerciseType(String name, List<String> tags) {
        this.name = name;
        this.tags = tags;
    }
}
