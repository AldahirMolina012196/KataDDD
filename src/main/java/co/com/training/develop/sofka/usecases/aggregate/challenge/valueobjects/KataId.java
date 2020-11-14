package co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects;

import co.com.sofka.domain.generic.Identity;

public class KataId extends Identity {
    public KataId(String value){super(value);}
    public static KataId of(String value){
        return new KataId(value);
    }
}
