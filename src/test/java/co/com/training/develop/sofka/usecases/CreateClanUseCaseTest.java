package co.com.training.develop.sofka.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.training.develop.sofka.usecases.aggregate.clan.Member;
import co.com.training.develop.sofka.usecases.aggregate.clan.commands.CreateClanCommand;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.CreatedClan;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;
import co.com.training.develop.sofka.usecases.usecases.CreateClanUseCase;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CreateClanUseCaseTest extends UseCaseHandleBaseTest{
    @Test
    void createClan(){
        List<Score> listScore = new ArrayList<>();
        List<Member> listMember = new ArrayList<>();
        var useCase = new CreateClanUseCase();
        var command = new CreateClanCommand(ClanId.of("Clan01"),
                new GroupGit(02,new Path("path"),new Name("Group01")),
                new Name("Clan01"),listMember,new Name("Member01"), MemberId.of("mm01"),new Gender("m"),
                new PersonId("1152702267"),
                new MemberGit(001,"imgAvatar","userName01"),
                new Email("aldahir.molina@sofka.com.co"),listScore
                );
        UseCaseHandler.getInstance()
                .asyncExecutor(useCase, new RequestCommand<>(command))
                .subscribe(subscriber);
        verify(subscriber, times(2)).onNext(eventCaptor.capture());

        var event = (CreatedClan)eventCaptor.getAllValues().get(0);
        Assertions.assertEquals("Clan01",event.getClanId().value());
        Assertions.assertEquals("Group01",event.getGroupGit().value().name().value());
    }

}