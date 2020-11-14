package co.com.training.develop.sofka.usecases.aggregate.dojo;

import co.com.sofka.domain.generic.Entity;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.Accomplishment;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.SenseiId;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.Speciality;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;

import java.util.List;

public class Sensei extends Entity<SenseiId> {
    private final Name name;
    private final PersonId personId;
    private final Speciality speciality;
    private final MemberGit memberGit;
    private final List<Accomplishment> accomplishments;

    public Sensei(SenseiId entityId, Name name, PersonId personId, Speciality speciality, MemberGit memberGit, List<Accomplishment> accomplishments) {
        super(entityId);
        this.name = name;
        this.personId = personId;
        this.speciality = speciality;
        this.memberGit = memberGit;
        this.accomplishments = accomplishments;
    }

    public Name name() {
        return name;
    }

    public PersonId personId() {
        return personId;
    }

    public Speciality speciality() {
        return speciality;
    }

    public MemberGit memberGit() {
        return memberGit;
    }

    public List<Accomplishment> accomplishments() {
        return accomplishments;
    }
}
