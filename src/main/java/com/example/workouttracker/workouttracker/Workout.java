package com.example.workouttracker.workouttracker;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Workout {
    @Id
    private String id;
    private LocalDateTime created;
    private List<ExerciseSet> set;
    private String notes;

    public Workout(LocalDateTime created, List<ExerciseSet> set, String notes) {
        this.created = created;
        this.set = set;
        this.notes = notes;
    }
}
