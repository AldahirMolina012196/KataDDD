package co.com.training.develop.sofka.usecases.aggregate.challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.KataId;

public class ExerciseRemovedOfKata extends DomainEvent {
    private final KataId kataId;
    private final Integer position;

    public ExerciseRemovedOfKata( KataId kataId, Integer position) {
        super("challange.events.ExerciseRemoveOfKata");
        this.kataId = kataId;
        this.position = position;
    }

    public KataId getKataId() {
        return kataId;
    }

    public Integer getPosition() {
        return position;
    }

}
