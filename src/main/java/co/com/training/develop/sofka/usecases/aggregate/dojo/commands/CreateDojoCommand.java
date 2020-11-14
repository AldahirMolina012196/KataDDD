package co.com.training.develop.sofka.usecases.aggregate.dojo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.*;

import java.util.List;

public class CreateDojoCommand implements Command {
    private DojoId dojoId;
    private DataInfo dataInfo;
    private GroupGit groupGit;
    private Location location;
    private SenseiId senseiId;
    private Name name;
    private PersonId personId;
    private Speciality speciality;
    private MemberGit memberGit;
    private List<Accomplishment> accomplishments;

    public CreateDojoCommand() {
    }

    public CreateDojoCommand(DojoId dojoId, DataInfo dataInfo, GroupGit groupGit, Location location,
                             SenseiId senseiId, Name name, PersonId personId, Speciality speciality, MemberGit memberGit,
                             List<Accomplishment> accomplishments) {
        this.dojoId = dojoId;
        this.dataInfo = dataInfo;
        this.groupGit = groupGit;
        this.location = location;
        this.senseiId = senseiId;
        this.name = name;
        this.personId = personId;
        this.speciality = speciality;
        this.memberGit = memberGit;
        this.accomplishments = accomplishments;
    }

    public DojoId getDojoId() {
        return dojoId;
    }

    public void setDojoId(DojoId dojoId) {
        this.dojoId = dojoId;
    }

    public DataInfo getDataInfo() {
        return dataInfo;
    }

    public void setDataInfo(DataInfo dataInfo) {
        this.dataInfo = dataInfo;
    }

    public GroupGit getGroupGit() {
        return groupGit;
    }

    public void setGroupGit(GroupGit groupGit) {
        this.groupGit = groupGit;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public SenseiId getSenseiId() {
        return senseiId;
    }

    public void setSenseiId(SenseiId senseiId) {
        this.senseiId = senseiId;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public void setPersonId(PersonId personId) {
        this.personId = personId;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public MemberGit getMemberGit() {
        return memberGit;
    }

    public void setMemberGit(MemberGit memberGit) {
        this.memberGit = memberGit;
    }

    public List<Accomplishment> getAccomplishments() {
        return accomplishments;
    }

    public void setAccomplishments(List<Accomplishment> accomplishments) {
        this.accomplishments = accomplishments;
    }
}
