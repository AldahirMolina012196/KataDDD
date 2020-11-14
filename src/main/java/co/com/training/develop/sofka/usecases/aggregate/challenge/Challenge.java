package co.com.training.develop.sofka.usecases.aggregate.challenge;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.challenge.events.*;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.Assessment;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.ChallengeId;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.Exercise;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.KataId;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.ClanId;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;

import java.util.List;
import java.util.Map;

public class Challenge extends AggregateEvent<ChallengeId> {
    protected Name name;
    protected List<ClanId> clanIds;
    protected DojoId dojoId;
    protected List<Kata> katas;
    protected Assessment assessment;
    protected Boolean isRevoked;
    protected Boolean isVisible;
    protected Integer durationDays;

    public Challenge(ChallengeId challengeId, Name name, DojoId dojoId) {
        super(challengeId);
        appendChange(new CreatedChallenge(challengeId,name,dojoId)).apply();
    }

    private Challenge(ChallengeId challengeId){
        super(challengeId);
        subscribe(new ChallengeChange(this));
    }

    public static Challenge from(ChallengeId challengeId, List<DomainEvent> events){
        var challenge = new Challenge((challengeId));
        events.forEach(challenge::applyEvent);
        return challenge;
    }

    public void subscriberClan(ClanId clanId){
        appendChange(new SubscribedClan(clanId)).apply();
    }

    public void addNewKata(KataId kataId, String purpose, Map<Integer,Exercise> exercises, String description, Integer limitOfTime){
        appendChange(new AddedKata(kataId,purpose,exercises,description,limitOfTime)).apply();
    }

    public void addExerciseOfKata(KataId kataId,Integer position, Exercise exercise){
        appendChange(new AddedExerciseOfKata(kataId,position,exercise)).apply();
    }

    public void removeExerciseOfKata(KataId kataId,Integer position){
        appendChange(new ExerciseRemovedOfKata(kataId,position)).apply();
    }

}
