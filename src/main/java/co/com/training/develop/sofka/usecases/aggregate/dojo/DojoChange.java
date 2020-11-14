package co.com.training.develop.sofka.usecases.aggregate.dojo;

import co.com.sofka.domain.generic.EventChange;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.AddedRule;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.AssignedSensei;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.ChangedLocation;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.CreatedDojo;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.Status;

import java.util.ArrayList;

public class DojoChange extends EventChange {
    public DojoChange(Dojo dojo) {
        apply((CreatedDojo event) ->{
            dojo.dataInfo = event.getDataInfo();
            dojo.groupGit = event.getGroupGit();
            dojo.location = event.getLocation();
            dojo.status = Status.CLOSED;
            dojo.rules = new ArrayList<>();
        });

        apply((AssignedSensei event) ->{
            dojo.sensei = new Sensei(event.getSenseiId(),event.getName(),event.getPersonId(),event.getSpeciality(),event.getMemberGit(),event.getAccomplishments());
        });

        apply((AddedRule event) ->{
            dojo.rules.add(event.getRule());
        });

        apply((ChangedLocation event) ->{
            dojo.location = dojo.location.setUrlMeet(event.getUrlMeetChange());
        });
    }
}
