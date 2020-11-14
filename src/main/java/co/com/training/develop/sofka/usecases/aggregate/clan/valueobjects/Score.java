package co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects;

import co.com.sofka.domain.generic.ValueObject;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;

import java.util.Date;
import java.util.Objects;

public class Score implements ValueObject<Score.Props> {
    private final Integer point;
    private final DojoId dojoId;
    private final Date date;

    public Score(Integer point, DojoId dojoId, Date date) {
        this.point = Objects.requireNonNull(point, "El valor de los puntos no puede ser null");
        this.dojoId = Objects.requireNonNull(dojoId, "El id del dojo no puede ser null");
        this.date = Objects.requireNonNull(date,"La fecha no puede ser null");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer point() {
                return point;
            }

            @Override
            public DojoId dojoId() {
                return dojoId;
            }

            @Override
            public Date date() {
                return date;
            }
        };
    }

    public interface  Props{
        Integer point();
        DojoId dojoId();
        Date date();
    }
}
