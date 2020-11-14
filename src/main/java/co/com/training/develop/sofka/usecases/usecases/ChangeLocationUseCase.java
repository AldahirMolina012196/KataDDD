package co.com.training.develop.sofka.usecases.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.training.develop.sofka.usecases.aggregate.dojo.Dojo;
import co.com.training.develop.sofka.usecases.aggregate.dojo.commands.ChangeLocationCommand;

public class ChangeLocationUseCase extends UseCase<RequestCommand<ChangeLocationCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeLocationCommand> requestCommand) {
        var command = requestCommand.getCommand();
        Dojo dojo = Dojo.from(command.getDojoId(), retrieveEvents());
        dojo.changeLocation(command.getUrlMeetChange());
        emit().onSuccess(new ResponseEvents(dojo.getUncommittedChanges()));
    }
}
