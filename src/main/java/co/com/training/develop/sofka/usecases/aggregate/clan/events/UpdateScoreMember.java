package co.com.training.develop.sofka.usecases.aggregate.clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.MemberId;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Score;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;

public class UpdateScoreMember extends DomainEvent {
    private final DojoId dojoId;
    private final MemberId memberId;
    private final Score score;

    public UpdateScoreMember(DojoId dojoId, MemberId memberId, Score score) {
        super("clan.events.UpdateScoreMember");
        this.dojoId = dojoId;
        this.memberId = memberId;
        this.score = score;
    }

    public DojoId getDojoId() {
        return dojoId;
    }


    public MemberId getMemberId() {
        return memberId;
    }

    public Score getScore() {
        return score;
    }
}
