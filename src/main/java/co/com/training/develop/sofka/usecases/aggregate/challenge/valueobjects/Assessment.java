package co.com.training.develop.sofka.usecases.aggregate.challenge.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Assessment implements ValueObject<Assessment.Props> {
    private final Integer degreeOfDificulty;
    private final String repoUrl;
    private final String summanry;

    public Assessment(Integer degreeOfDificulty, String repoUrl, String summanry) {
        this.degreeOfDificulty = Objects.requireNonNull(degreeOfDificulty,"El degreeOfDificulty debe de ser diferente de null");
        this.repoUrl = Objects.requireNonNull(repoUrl,"El repoUrl no puede ser null");
        this.summanry = Objects.requireNonNull(summanry,"Elo summary no puede ser null");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer degreeOfDificulty() {
                return degreeOfDificulty;
            }

            @Override
            public String repoUrl() {
                return repoUrl;
            }

            @Override
            public String summanry() {
                return summanry;
            }
        };
    }

    public interface Props{
        Integer degreeOfDificulty();
        String repoUrl();
        String summanry();
    }
}
