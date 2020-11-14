package co.com.training.develop.sofka.usecases.listeners;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.training.develop.sofka.usecases.UseCaseHandleBaseTest;
import co.com.training.develop.sofka.usecases.aggregate.clan.Member;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.AddedMember;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.CreatedClan;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.UpdateScoreMember;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.*;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.CreatedDojo;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.*;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UpdateScoreUseCaseTest extends UseCaseHandleBaseTest {
    @Test
    void updateScore() throws InterruptedException{
        var useCase = new UpdateScoreUseCase();
        List<Score> listScore = new ArrayList<>();
        List<Member> listMember = new ArrayList<>();
        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedDojo(DojoId.of("dj001"),
                        new DataInfo("infoName","infoLengend"),
                        new GroupGit(001,new Path("path01"), new Name("name01")),
                        new Location("urlMeet","location","description",
                                new OpeningHours(12,16, Frecuency.WEEKLY)
                        )),
                new CreatedClan(ClanId.of("Clan01"),
                    new GroupGit(02,new Path("path"),new Name("Group01")),
                    new Name("Clan01"),listMember),
                new AddedMember(new Name("Member01"), MemberId.of("mm01"),new Gender("m"),
                        new PersonId("1152702267"),
                        new MemberGit(001,"imgAvatar","userName01"),
                        new Email("aldahir.molina@sofka.com.co"),listScore)
        ));
        useCase.addRepository(repository);

        var event = new UpdateScoreMember(DojoId.of("dj001"),MemberId.of("mm01"),new Score(60,DojoId.of("dj001"),new Date()));
        Thread.sleep(400);

        UseCaseHandler.getInstance()
                .setIdentifyExecutor("dj00")
                .asyncExecutor(useCase, new TriggeredEvent<>(event))
                .subscribe(subscriber);

        verify(subscriber).onNext(eventCaptor.capture());
        Assertions.assertTrue(eventCaptor.getValue() instanceof UpdateScoreMember);
    }

}