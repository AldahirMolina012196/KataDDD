package co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects;

import co.com.sofka.domain.generic.Identity;

public class ChallengeId extends Identity {
    public ChallengeId(String value){super(value);}
    public static ChallengeId of(String value){
        return new ChallengeId(value);
    }
}
