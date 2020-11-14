package co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Gender implements ValueObject {
    private final String value;

    public Gender(String value) {
        this.value = Objects.requireNonNull(value, "El generao no puede ser null");
    }

    @Override
    public Object value() {
        return value;
    }
}
