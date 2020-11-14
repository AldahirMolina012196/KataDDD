package co.com.training.develop.sofka.usecases.aggregate.challenge;

import co.com.sofka.domain.generic.Entity;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.Exercise;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.KataId;

import java.util.Map;

public class Kata extends Entity<KataId> {
    private String purpose;
    private Map<Integer, Exercise> exercises;
    private String description;
    private Integer limitOfTime;

    public Kata(KataId kataId, String purpose, Map<Integer,Exercise> exercises, String description, Integer limitOfTime) {
        super(kataId);
        this.purpose = purpose;
        this.exercises = exercises;
        this.description = description;
        this.limitOfTime = limitOfTime;
    }

    public void addNewExercise(Integer position,Exercise exercise){
        exercises.put(position, exercise);
    }

    public void removeExercise(Integer position){
        exercises.remove(position);
    }

    public String purpose() {
        return purpose;
    }

    public Map<Integer, Exercise> getExercises() {
        return exercises;
    }

    public String description() {
        return description;
    }

    public Integer limitOfTime() {
        return limitOfTime;
    }
}
