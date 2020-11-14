package co.com.training.develop.sofka.usecases.aggregate.challenge.commands;

import co.com.sofka.domain.generic.Command;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.ChallengeId;
import co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects.KataId;


import java.util.List;

public class AddExerciseOfKataCommad implements Command {
    private ChallengeId challengeId;
    private KataId kataId;
    private Integer level;
    private List<String> metadata;
    private String goal;
    private Integer position;

    public AddExerciseOfKataCommad(ChallengeId challengeId, KataId kataId, Integer level, List<String> metadata, String goal, Integer position) {
        this.challengeId = challengeId;
        this.kataId = kataId;
        this.level = level;
        this.metadata = metadata;
        this.goal = goal;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<String> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<String> metadata) {
        this.metadata = metadata;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}