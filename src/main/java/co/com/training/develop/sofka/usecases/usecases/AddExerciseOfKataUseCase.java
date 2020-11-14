package co.com.training.develop.sofka.usecases.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.training.develop.sofka.usecases.aggregate.challenge.Challenge;
import co.com.training.develop.sofka.usecases.aggregate.challenge.commands.AddExerciseOfKataCommad;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.Exercise;

public class AddExerciseOfKataUseCase extends UseCase<RequestCommand<AddExerciseOfKataCommad>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddExerciseOfKataCommad> requestCommand) {
        var command = requestCommand.getCommand();
        Challenge challenge = Challenge.from(command.getChallengeId(),retrieveEvents());
        challenge.addExerciseOfKata(command.getKataId(),command.getPosition(),new Exercise(command.getLevel(),command.getMetadata(),command.getGoal()));
        emit().onSuccess(new ResponseEvents(challenge.getUncommittedChanges()));
    }
}
