package co.com.training.develop.sofka.usecases.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.training.develop.sofka.usecases.aggregate.dojo.Dojo;
import co.com.training.develop.sofka.usecases.aggregate.dojo.commands.CreateDojoCommand;

public class CreateDojoUseCase extends UseCase<RequestCommand<CreateDojoCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateDojoCommand> requestCommand) {
        var command = requestCommand.getCommand();
        Dojo dojo = new Dojo(command.getDojoId(),command.getDataInfo(),command.getGroupGit(),command.getLocation());
        dojo.assignSensei(command.getSenseiId(),command.getName(),command.getPersonId(),command.getSpeciality(),command.getMemberGit(),
                command.getAccomplishments());
        emit().onSuccess(new ResponseEvents(dojo.getUncommittedChanges()));
    }
}
