package co.com.training.develop.sofka.usecases.aggregate.challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.ClanId;

public class SubscribedClan extends DomainEvent {
    private final ClanId clanId;

    public SubscribedClan(ClanId clanId) {
        super("challenge.events.SubscribedClan");
        this.clanId = clanId;
    }

    public ClanId getClanId() {
        return clanId;
    }
}
