package co.com.training.develop.sofka.usecases.aggregate.dojo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;

public class ChangeLocationCommand implements Command {
    private DojoId dojoId;
    private String urlMeetChange;

    public ChangeLocationCommand(DojoId dojoId, String urlMeetChange) {
        this.dojoId = dojoId;
        this.urlMeetChange = urlMeetChange;
    }

    public ChangeLocationCommand() {
    }

    public DojoId getDojoId() {
        return dojoId;
    }

    public void setDojoId(DojoId dojoId) {
        this.dojoId = dojoId;
    }

    public String getUrlMeetChange() {
        return urlMeetChange;
    }

    public void setUrlMeetChange(String urlMeetChange) {
        this.urlMeetChange = urlMeetChange;
    }
}
