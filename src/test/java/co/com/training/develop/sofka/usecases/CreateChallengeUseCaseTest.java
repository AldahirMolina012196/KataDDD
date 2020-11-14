package co.com.training.develop.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.training.develop.sofka.usecases.aggregate.challenge.commands.CreateChallengeCommand;
import co.com.training.develop.sofka.usecases.aggregate.challenge.events.CreatedChallenge;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.ChallengeId;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.ClanId;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.usecases.CreateChallengeUseCase;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CreateChallengeUseCaseTest extends UseCaseHandleBaseTest {
    @Test
    void createChallenge(){
        var useCase = new CreateChallengeUseCase();
        var command = new CreateChallengeCommand(ChallengeId.of("idChallenge01"),
                                new Name("Challenge01"), DojoId.of("dj001"),
                                ClanId.of("cl01"));
        UseCaseHandler.getInstance()
                .asyncExecutor(useCase, new RequestCommand<>(command))
                .subscribe(subscriber);

        verify(subscriber, times(2)).onNext(eventCaptor.capture());

        var event =(CreatedChallenge)eventCaptor.getAllValues().get(0);
        Assertions.assertEquals("idChallenge01",event.getChallengeId().value());
        Assertions.assertEquals("Challenge01",event.getName().value());
        Assertions.assertEquals("dj001",event.getDojoId().value());
    }
}