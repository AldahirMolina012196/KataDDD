package co.com.training.develop.sofka.usecases.aggregate.challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.Exercise;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.KataId;

import java.util.Map;

public class AddedKata extends DomainEvent {
    private final KataId kataId;
    private final String purpose;
    private final Map<Integer,Exercise> exercises;
    private final String description;
    private final Integer limitOfTime;

    public AddedKata(KataId kataId, String purpose, Map<Integer,Exercise> exercises, String description, Integer limitOfTime) {
        super("challenge.events.AddedKata");
        this.kataId = kataId;
        this.purpose = purpose;
        this.exercises = exercises;
        this.description = description;
        this.limitOfTime = limitOfTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public Map<Integer,Exercise> getExercises() {
        return exercises;
    }

    public String getDescription() {
        return description;
    }

    public Integer getLimitOfTime() {
        return limitOfTime;
    }

    public KataId getKataId() {
        return kataId;
    }
}
