package co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class Accomplishment implements ValueObject<Accomplishment.Props> {
    private final String label;
    private final Integer point;
    private final Date date;

    public Accomplishment(String label, Integer point, Date date) {
        this.label = Objects.requireNonNull(label,"El label no puede ser null");
        this.point = Objects.requireNonNull(point, "El point no puede ser null");
        this.date = Objects.requireNonNull(date, "El date no puede ser null");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String label() {
                return label;
            }

            @Override
            public Integer point() {
                return point;
            }

            @Override
            public Date date() {
                return date;
            }
        };
    }

    public interface Props{
        String label();
        Integer point();
        Date date();
    }
}
