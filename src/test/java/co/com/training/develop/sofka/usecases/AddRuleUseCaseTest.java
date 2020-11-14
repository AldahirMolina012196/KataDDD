package co.com.training.develop.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Path;
import co.com.training.develop.sofka.usecases.aggregate.dojo.commands.AddRuleCommand;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.AddedRule;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.CreatedDojo;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.usecases.AddRuleUseCase;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class AddRuleUseCaseTest extends UseCaseHandleBaseTest {
    @Test
    void addRule(){
        var useCase = new AddRuleUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedDojo(DojoId.of("dj001"),
                        new DataInfo("infoName","infoLengend"),
                        new GroupGit(001,new Path("path01"), new Name("name01")),
                        new Location("urlMeet","location","description",
                                new OpeningHours(12,16, Frecuency.WEEKLY)
                                ))
        ));
        useCase.addRepository(repository);

        var command = new AddRuleCommand(DojoId.of("dj001"),new Rule("Rule01"));

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("dj001")
                .asyncExecutor(useCase, new RequestCommand<>(command))
                .subscribe(subscriber);

        verify(subscriber).onNext(eventCaptor.capture());

        var event =(AddedRule)eventCaptor.getValue();
        Assertions.assertEquals("Rule01",event.getRule().value());
    }
}