package co.com.training.develop.sofka.usecases.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.training.develop.sofka.usecases.aggregate.challenge.Challenge;
import co.com.training.develop.sofka.usecases.aggregate.challenge.commands.AddKataCommand;

public class AddKataUseCase extends UseCase<RequestCommand<AddKataCommand>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddKataCommand> requestCommand) {
        var command = requestCommand.getCommand();
        Challenge challenge = Challenge.from(command.getChallengeId(), retrieveEvents());
        challenge.addNewKata(command.getKataId(),
                                    command.getPurpose(),command.getExercises(),command.getDescription(),command.getLimitOfTime());
        emit().onSuccess(new ResponseEvents(challenge.getUncommittedChanges()));
    }
}
