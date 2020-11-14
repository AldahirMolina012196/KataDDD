package co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rule implements ValueObject<String> {
    private final String value;

    public Rule(String value) {
        this.value = Objects.requireNonNull(value, "El rule no puede ser null");
    }

    @Override
    public String value() {
        return value;
    }
}
