package co.com.training.develop.sofka.usecases.domaingeneric;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {
    private final String value;

    public Name(String value) {
        this.value = Objects.requireNonNull(value,"El nombre no puede ser null");
    }

    @Override
    public String value() {
        return value;
    }
}
