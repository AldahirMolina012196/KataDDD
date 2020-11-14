package co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects;

import co.com.sofka.domain.generic.Identity;

public class SenseiId extends Identity {
    public SenseiId(String value){
        super(value);
    }
    public static SenseiId of(String value){
        return new SenseiId(value);
    }
}
