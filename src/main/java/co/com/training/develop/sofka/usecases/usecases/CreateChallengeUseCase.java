package co.com.training.develop.sofka.usecases.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.training.develop.sofka.usecases.aggregate.challenge.Challenge;
import co.com.training.develop.sofka.usecases.aggregate.challenge.commands.CreateChallengeCommand;

public class CreateChallengeUseCase extends UseCase<RequestCommand<CreateChallengeCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateChallengeCommand> requestCommand) {
        var command = requestCommand.getCommand();
        Challenge challenge = new Challenge(command.getChallengeId(),command.getName(),command.getDojoId());
        challenge.subscriberClan(command.getClanId());
        emit().onSuccess(new ResponseEvents(challenge.getUncommittedChanges()));
    }
}
