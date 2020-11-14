package co.com.training.develop.sofka.usecases.aggregate.challenge.commands;

import co.com.sofka.domain.generic.Command;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.ChallengeId;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.ClanId;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;

public class CreateChallengeCommand implements Command {
    private ChallengeId challengeId;
    private Name name;
    private DojoId dojoId;
    private ClanId clanId;


    public CreateChallengeCommand() {
    }

    public CreateChallengeCommand(ChallengeId challengeId, Name name, DojoId dojoId, ClanId clanId) {
        this.challengeId = challengeId;
        this.name = name;
        this.dojoId = dojoId;
        this.clanId = clanId;
    }

    public ChallengeId getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(ChallengeId challengeId) {
        this.challengeId = challengeId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public DojoId getDojoId() {
        return dojoId;
    }

    public ClanId getClanId() {
        return clanId;
    }
}
