package co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Path  implements ValueObject<String> {
    private final String value;

    public Path(String value) {
        this.value = Objects.requireNonNull(value, "El parh no puede ser null");
    }

    @Override
    public String value() {
        return value;
    }
}
