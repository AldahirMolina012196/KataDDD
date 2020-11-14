package co.com.training.develop.sofka.usecases.aggregate.challenge.commands;

import co.com.sofka.domain.generic.Command;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.ChallengeId;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.KataId;

public class RemoveExerciseOfKataCommad implements Command {
    private ChallengeId challengeId;
    private KataId kataId;
    private Integer position;

    public RemoveExerciseOfKataCommad(ChallengeId challengeId, KataId kataId, Integer position) {
        this.challengeId = challengeId;
        this.kataId = kataId;
        this.position = position;
    }

    public ChallengeId getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(ChallengeId challengeId) {
        this.challengeId = challengeId;
    }

    public KataId getKataId() {
        return kataId;
    }

    public void setKataId(KataId kataId) {
        this.kataId = kataId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
