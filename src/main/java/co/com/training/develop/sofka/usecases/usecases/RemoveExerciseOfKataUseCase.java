package co.com.training.develop.sofka.usecases.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.training.develop.sofka.usecases.aggregate.challenge.Challenge;
import co.com.training.develop.sofka.usecases.aggregate.challenge.commands.RemoveExerciseOfKataCommad;

public class RemoveExerciseOfKataUseCase extends UseCase<RequestCommand<RemoveExerciseOfKataCommad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemoveExerciseOfKataCommad> requestCommand) {
        var command = requestCommand.getCommand();
        Challenge challenge = Challenge.from(command.getChallengeId(), retrieveEvents());
        challenge.removeExerciseOfKata(command.getKataId(),command.getPosition());
        emit().onSuccess(new ResponseEvents(challenge.getUncommittedChanges()));
    }
}
