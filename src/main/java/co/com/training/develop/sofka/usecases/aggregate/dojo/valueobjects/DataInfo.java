package co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DataInfo implements ValueObject<DataInfo.Props> {
    private final String name;
    private final String legend;


    public DataInfo(String name, String legend) {
        this.name = Objects.requireNonNull(name, "El name no puede ser null");
        this.legend = Objects.requireNonNull(legend, "Legend no puede ser null");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String name() {
                return name;
            }

            @Override
            public String legend() {
                return legend;
            }
        };
    }


    public interface  Props{
        String name();
        String legend();
    }
}

