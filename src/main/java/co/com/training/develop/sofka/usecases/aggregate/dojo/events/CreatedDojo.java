package co.com.training.develop.sofka.usecases.aggregate.dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DataInfo;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.DojoId;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.Location;


public class CreatedDojo extends DomainEvent {
    private final DojoId dojoId;
    private final DataInfo dataInfo;
    private final GroupGit groupGit;
    private final Location location;

    public CreatedDojo(DojoId dojoId, DataInfo dataInfo, GroupGit groupGit, Location location) {
        super("dojo.events.DojoCreated");
        this.dojoId = dojoId;
        this.dataInfo = dataInfo;
        this.groupGit = groupGit;
        this.location = location;
    }


    public DojoId getDojoId() {
        return dojoId;
    }

    public DataInfo getDataInfo() {
        return dataInfo;
    }

    public GroupGit getGroupGit() {
        return groupGit;
    }

    public Location getLocation() {
        return location;
    }
}
