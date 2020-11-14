package co.com.training.develop.sofka.usecases.aggregate.dojo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.Rule;

public class AddRuleCommand implements Command {
    private DojoId dojoId;
    private Rule rule;

    public AddRuleCommand(DojoId dojoId, Rule rule) {
        this.dojoId = dojoId;
        this.rule = rule;
    }

    public AddRuleCommand() {
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public DojoId getDojoId() {
        return dojoId;
    }

    public void setDojoId(DojoId dojoId) {
        this.dojoId = dojoId;
    }
}
