package co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects;

import co.com.sofka.domain.generic.Identity;


public class ClanId extends Identity {
    public ClanId(String value){super(value);}
    public static ClanId of(String value){return new ClanId(value);}
}
