package co.com.training.develop.sofka.usecases.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.training.develop.sofka.usecases.aggregate.dojo.Dojo;
import co.com.training.develop.sofka.usecases.aggregate.dojo.commands.AddRuleCommand;

public class AddRuleUseCase extends UseCase<RequestCommand<AddRuleCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddRuleCommand> requestCommand) {
        var command = requestCommand.getCommand();
        Dojo dojo = Dojo.from(command.getDojoId(), retrieveEvents());
        dojo.addRule(command.getRule());
        emit().onSuccess(new ResponseEvents(dojo.getUncommittedChanges()));
    }
}
