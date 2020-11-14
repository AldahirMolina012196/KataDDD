package co.com.training.develop.sofka.usecases.listeners;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.UpdateScoreMember;
import co.com.training.develop.sofka.usecases.aggregate.dojo.Dojo;

public class UpdateScoreUseCase extends UseCase<TriggeredEvent<UpdateScoreMember>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<UpdateScoreMember> triggeredEvent) {
        var event = triggeredEvent.getDomainEvent();
        Dojo dojo = Dojo.from(event.getDojoId(), retrieveEvents());
        dojo.evaluateClan(event.getDojoId(),event.getMemberId(),event.getScore());
        emit().onSuccess(new ResponseEvents(dojo.getUncommittedChanges()));
    }
}
