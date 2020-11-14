package co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Email implements ValueObject<String> {
    private final String value;

    public Email(String value) {
        this.value = Objects.requireNonNull(value, "El Email no puede ser null");
    }

    @Override
    public String value() {
        return null;
    }
}
