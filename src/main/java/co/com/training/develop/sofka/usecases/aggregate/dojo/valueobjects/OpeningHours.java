package co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

public class OpeningHours implements ValueObject<OpeningHours.Props> {
    private final Integer hourStart;
    private final Integer hourEnd;
    private final Frecuency frecuency;

    public OpeningHours(Integer hourStart, Integer hourEnd, Frecuency frecuency) {
        this.hourStart = hourStart;
        this.hourEnd = hourEnd;
        this.frecuency = frecuency;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer hourStart() {
                return hourStart;
            }

            @Override
            public Integer hourEnd() {
                return hourEnd;
            }

            @Override
            public Frecuency frecuency() {
                return frecuency;
            }
        };
    }

    public interface  Props{
        Integer hourStart();
        Integer hourEnd();
        Frecuency frecuency();
    }
}
