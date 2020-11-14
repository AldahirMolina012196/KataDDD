package co.com.training.develop.sofka.usecases.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.training.develop.sofka.usecases.aggregate.clan.Clan;
import co.com.training.develop.sofka.usecases.aggregate.clan.commands.CreateClanCommand;

public class CreateClanUseCase extends UseCase<RequestCommand<CreateClanCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateClanCommand> requestCommand) {
        var command = requestCommand.getCommand();
        Clan clan = new Clan(command.getClanId(), command.getGroupGit(),command.getNameClan(),command.getListMembers());
        clan.addNewMember(command.getNameMember(),command.getMemberId(),command.getGender(),
                command.getPersonId(),command.getMemberGit(),command.getEmail(),command.getListScore());
        emit().onSuccess(new ResponseEvents(clan.getUncommittedChanges()));
    }
}
