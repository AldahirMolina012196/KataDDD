package co.com.training.develop.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.training.develop.sofka.usecases.aggregate.challenge.commands.RemoveExerciseOfKataCommad;
import co.com.training.develop.sofka.usecases.aggregate.challenge.events.AddedKata;
import co.com.training.develop.sofka.usecases.aggregate.challenge.events.CreatedChallenge;
import co.com.training.develop.sofka.usecases.aggregate.challenge.events.ExerciseRemovedOfKata;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.ChallengeId;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.Exercise;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.KataId;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.usecases.RemoveExerciseOfKataUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RemoveExerciseOfKataUseCaseTest extends UseCaseHandleBaseTest{
    @Test
    void removeExercise(){
        var useCase = new RemoveExerciseOfKataUseCase();
        Map<Integer, Exercise> MapExercises = new HashMap<>();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedChallenge(ChallengeId.of("idChallenge01"),
                        new Name("Challenge01"), DojoId.of("dj001")),
                new AddedKata(KataId.of("idKata01"),"purpose",MapExercises,
                        "descriptionTest",10)
        ));
        useCase.addRepository(repository);

        var command = new RemoveExerciseOfKataCommad(ChallengeId.of("idChallenge01"),KataId.of("idKata01"),1);

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("idChallenge01")
                .asyncExecutor(useCase, new RequestCommand<>(command))
                .subscribe(subscriber);

        verify(subscriber).onNext(eventCaptor.capture());

        var event = (ExerciseRemovedOfKata)eventCaptor.getValue();
        Assertions.assertEquals("idKata01",event.getKataId().value());
    }
}