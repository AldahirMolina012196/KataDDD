package co.com.training.develop.sofka.usecases;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.training.develop.sofka.usecases.aggregate.challenge.commands.AddKataCommand;
import co.com.training.develop.sofka.usecases.aggregate.challenge.events.AddedKata;
import co.com.training.develop.sofka.usecases.aggregate.challenge.events.CreatedChallenge;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.ChallengeId;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.Exercise;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.KataId;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.usecases.AddKataUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AddKataUseCaseTest extends UseCaseHandleBaseTest{
    @Test
    void addKata(){
        var useCase = new AddKataUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedChallenge(ChallengeId.of("idChallenge01"),
                        new Name("Challenge01"), DojoId.of("dj001"))
        ));
        useCase.addRepository(repository);

        Map<Integer,Exercise> MapExercises = new HashMap<>();

        var command = new AddKataCommand(ChallengeId.of("idChallenge01"), KataId.of("idKata01"),MapExercises,"purpose",
                            "descriptionTest",10);

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("idChallenge01")
                .asyncExecutor(useCase, new RequestCommand<>(command))
                .subscribe(subscriber);

        verify(subscriber).onNext(eventCaptor.capture());

        var event = (AddedKata)eventCaptor.getValue();
        Assertions.assertEquals("idKata01",event.getKataId().value());
    }
}