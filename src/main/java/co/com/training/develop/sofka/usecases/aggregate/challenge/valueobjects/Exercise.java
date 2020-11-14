package co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.List;
import java.util.Objects;

public class Exercise implements ValueObject<Exercise.Props> {
    private final Integer level;
    private final List<String> metadata;
    private final String goal;

    public Exercise(Integer level, List metadata, String goal) {
        this.level = Objects.requireNonNull(level,"El level no puede ser null");
        this.metadata = Objects.requireNonNull(metadata,"La metadata no puede ser null");
        this.goal = Objects.requireNonNull(goal, "Los Goal no pueden ser null");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer level() {
                return level;
            }

            @Override
            public List<String> metadata() {
                return metadata;
            }

            @Override
            public String goal() {
                return goal;
            }
        };
    }

    public interface Props{
        Integer level();
        List<String> metadata();
        String goal();
    }
}
