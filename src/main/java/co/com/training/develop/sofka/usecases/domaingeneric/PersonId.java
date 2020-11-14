package co.com.training.develop.sofka.usecases.domaingeneric;

import co.com.sofka.domain.generic.Identity;

public class PersonId extends Identity {
    public PersonId(String value){
        super(value);
    }
    public static PersonId of(String value){
        return new PersonId(value);
    }
}
