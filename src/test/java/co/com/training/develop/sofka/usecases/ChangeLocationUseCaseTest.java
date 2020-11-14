package co.com.training.develop.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Path;
import co.com.training.develop.sofka.usecases.aggregate.dojo.commands.ChangeLocationCommand;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.ChangedLocation;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.CreatedDojo;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.usecases.ChangeLocationUseCase;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ChangeLocationUseCaseTest extends UseCaseHandleBaseTest{
    @Test
    void changeUrlMeet(){
        var useCase = new ChangeLocationUseCase();

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedDojo(DojoId.of("dj001"),
                        new DataInfo("infoName","infoLengend"),
                        new GroupGit(001,new Path("path01"), new Name("name01")),
                        new Location("urlMeet","location","description",
                                new OpeningHours(12,16, Frecuency.WEEKLY)
                        ))
        ));
        useCase.addRepository(repository);

        var command = new ChangeLocationCommand(DojoId.of("dj001"),"urlMeetChange");

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("dj001")
                .asyncExecutor(useCase, new RequestCommand<>(command))
                .subscribe(subscriber);

        verify(subscriber).onNext(eventCaptor.capture());

        var event = (ChangedLocation)eventCaptor.getValue();
        Assertions.assertEquals("urlMeetChange",event.getUrlMeetChange());
    }
}