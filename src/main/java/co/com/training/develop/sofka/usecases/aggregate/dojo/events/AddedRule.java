package co.com.training.develop.sofka.usecases.aggregate.dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.Rule;

public class AddedRule extends DomainEvent {
    private final Rule rule;

    public AddedRule( Rule rule) {
        super("dojo.events.AddedRule");
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
