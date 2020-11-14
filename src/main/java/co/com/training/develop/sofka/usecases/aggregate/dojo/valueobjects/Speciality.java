package co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Speciality implements ValueObject<String> {
    private final String value;

    public Speciality(String value) {
        this.value = Objects.requireNonNull(value, "Speciality no puede ser null");
    }

    @Override
    public String value() {
        return value;
    }
}
