package co.com.training.develop.sofka.usecases.aggregate.challenge.commands;

import co.com.sofka.domain.generic.Command;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.ChallengeId;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.Exercise;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.KataId;

import java.util.Map;

public class AddKataCommand implements Command {
    private ChallengeId challengeId;
    private KataId kataId;
    private Map<Integer,Exercise> exercises;
    private String purpose;
    private String description;
    private Integer limitOfTime;

    public AddKataCommand() {
    }

    public AddKataCommand(ChallengeId challengeId, KataId kataId, Map<Integer,Exercise> exercises, String purpose, String description, Integer limitOfTime) {
        this.challengeId = challengeId;
        this.kataId = kataId;
        this.exercises = exercises;
        this.purpose = purpose;
        this.description = description;
        this.limitOfTime = limitOfTime;
    }

    public Map<Integer,Exercise> getExercises() {
        return exercises;
    }

    public KataId getKataId() {
        return kataId;
    }

    public void setKataId(KataId kataId) {
        this.kataId = kataId;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLimitOfTime() {
        return limitOfTime;
    }

    public void setLimitOfTime(Integer limitOfTime) {
        this.limitOfTime = limitOfTime;
    }

    public ChallengeId getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(ChallengeId challengeId) {
        this.challengeId = challengeId;
    }
}
