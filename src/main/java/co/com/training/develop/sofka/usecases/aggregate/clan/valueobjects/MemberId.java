package co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects;

import co.com.sofka.domain.generic.Identity;


public class MemberId extends Identity {
    public MemberId(String value){
        super(value);
    }
    public static MemberId of(String value){
        return new MemberId(value);
    }
}
