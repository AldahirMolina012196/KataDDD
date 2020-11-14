package co.com.training.develop.sofka.usecases.aggregate.dojo.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ChangedLocation extends DomainEvent {
    private final String urlMeetChange;

    public ChangedLocation(String urlMeetChange) {
        super("dojo.events.ChangeLocation");
        this.urlMeetChange = urlMeetChange;
    }

    public String getUrlMeetChange() {
        return urlMeetChange;
    }
}
