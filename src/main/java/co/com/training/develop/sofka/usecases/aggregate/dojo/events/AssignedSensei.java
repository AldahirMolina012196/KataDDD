package co.com.training.develop.sofka.usecases.aggregate.dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.Accomplishment;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.SenseiId;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.Speciality;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;

import java.util.List;

public class AssignedSensei extends DomainEvent {
    private final SenseiId senseiId;
    private final Name name;
    private final PersonId personId;
    private final Speciality speciality;
    private final MemberGit memberGit;
    private final List<Accomplishment> accomplishments;

    public AssignedSensei(SenseiId senseiId, Name name, PersonId personId, Speciality speciality, MemberGit memberGit, List<Accomplishment> accomplishments) {
        super("dojo.events.AssignedSensei");
        this.senseiId = senseiId;
        this.name = name;
        this.personId = personId;
        this.speciality = speciality;
        this.memberGit = memberGit;
        this.accomplishments = accomplishments;
    }

    public SenseiId getSenseiId() {
        return senseiId;
    }

    public Name getName() {
        return name;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public MemberGit getMemberGit() {
        return memberGit;
    }

    public List<Accomplishment> getAccomplishments() {
        return accomplishments;
    }
}
