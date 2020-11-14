package co.com.training.develop.sofka.usecases.aggregate.challenge;

import co.com.sofka.domain.generic.EventChange;
import co.com.training.develop.sofka.usecases.aggregate.challenge.events.*;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.Assessment;

import java.util.ArrayList;

public class ChallengeChange extends EventChange {
    public ChallengeChange(Challenge challenge){
        apply((CreatedChallenge event) ->{
            challenge.dojoId = event.getDojoId();
            challenge.name = event.getName();
            challenge.clanIds = new ArrayList<>();
            challenge.katas = new ArrayList<>();
            challenge.assessment = new Assessment(0,"","");
            challenge.isRevoked = false;
            challenge.isVisible = false;
            challenge.durationDays = 0;
        });

        apply((SubscribedClan event) ->{
            challenge.clanIds.add(event.getClanId());
        });

        apply((AddedKata event) ->{
            challenge.katas.add(new Kata(event.getKataId(),event.getPurpose(),event.getExercises(),event.getDescription(),event.getLimitOfTime()));
        });

        apply((AddedExerciseOfKata event) ->{
            for(Kata kata : challenge.katas){
                if(kata.identity().equals(event.getKataId())){
                    kata.addNewExercise(event.getPosition(),event.getExercise());
                }
            }
        });

        apply((ExerciseRemovedOfKata event) ->{
            for(Kata kata : challenge.katas){
                if(kata.identity().equals(event.getKataId())){
                    kata.removeExercise(event.getPosition());
                }
            }
        });
    }
}
