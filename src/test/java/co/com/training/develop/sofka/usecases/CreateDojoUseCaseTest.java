package co.com.training.develop.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Path;
import co.com.training.develop.sofka.usecases.aggregate.dojo.commands.CreateDojoCommand;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.CreatedDojo;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;
import co.com.training.develop.sofka.usecases.usecases.CreateDojoUseCase;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CreateDojoUseCaseTest extends UseCaseHandleBaseTest {
    @Test
    void createDojo(){
        var useCase = new CreateDojoUseCase();
        List<Accomplishment> accomplishments = new ArrayList<>();
        var command = new CreateDojoCommand(DojoId.of("dj001"),
                new DataInfo("nameString01","legend01"),
                new GroupGit(001,new Path("Path01"), new Name("nameGroupGit01")),
                new Location("urlMeet01","locacioString01","description01",
                        new OpeningHours(12,16, Frecuency.WEEKLY)),
                SenseiId.of("idSensei01"),
                new Name("nameSensei01"),
                PersonId.of("personId01"),
                new Speciality("speciality01"),
                new MemberGit(01,"dirImgAvatar01","userName01"),accomplishments);

        UseCaseHandler.getInstance()
                .asyncExecutor(useCase, new RequestCommand<>(command))
                .subscribe(subscriber);

        verify(subscriber, times(2)).onNext(eventCaptor.capture());

        var event = (CreatedDojo)eventCaptor.getAllValues().get(0);
        Assertions.assertEquals("dj001", event.getDojoId().value());
        Assertions.assertEquals("urlMeet01", event.getLocation().value().urlMeet());
    }
}