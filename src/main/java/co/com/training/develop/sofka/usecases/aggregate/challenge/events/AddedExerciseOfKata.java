package co.com.training.develop.sofka.usecases.aggregate.challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.Exercise;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.KataId;


public class AddedExerciseOfKata extends DomainEvent {
    private final KataId kataId;
    private final Integer position;
    private final Exercise exercise;

    public AddedExerciseOfKata(KataId kataId, Integer position, Exercise exercise) {
        super("challenge.events.AddedExerciseOfKata");
        this.kataId = kataId;
        this.position = position;
        this.exercise = exercise;
    }

    public KataId getKataId() {
        return kataId;
    }

    public Integer getPosition() {
        return position;
    }

    public Exercise getExercise() {
        return exercise;
    }
}
