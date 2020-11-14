package co.com.training.develop.sofka.usecases.aggregate.challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.ChallengeId;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;

public class CreatedChallenge extends DomainEvent {
    private final ChallengeId challengeId;
    private final Name name;
    private final DojoId dojoId;

    public CreatedChallenge( ChallengeId challengeId, Name name, DojoId dojoId) {
        super("challenge.events.CreatedChallenge");
        this.challengeId = challengeId;
        this.name = name;
        this.dojoId = dojoId;
    }

    public ChallengeId getChallengeId() {
        return challengeId;
    }

    public Name getName() {
        return name;
    }

    public DojoId getDojoId() {
        return dojoId;
    }
}
