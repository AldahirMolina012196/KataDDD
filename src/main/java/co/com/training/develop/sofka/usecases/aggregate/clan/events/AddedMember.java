package co.com.training.develop.sofka.usecases.aggregate.clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Email;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Gender;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.MemberId;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Score;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;

import java.util.List;

public class AddedMember extends DomainEvent {
    private final Name name;
    private final MemberId memberId;
    private final Gender gender;
    private final PersonId personId;
    private final MemberGit memberGit;
    private final Email email;
    private final List<Score> listScore;

    public AddedMember(Name name, MemberId memberId, Gender gender, PersonId personId, MemberGit memberGit, Email email, List<Score> listScore) {
        super("clan.events.AddedMember");
        this.name = name;
        this.memberId = memberId;
        this.gender = gender;
        this.personId = personId;
        this.memberGit = memberGit;
        this.email = email;
        this.listScore = listScore;
    }

    public List<Score> getListScore() {
        return listScore;
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public Gender getGender() {
        return gender;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public MemberGit getMemberGit() {
        return memberGit;
    }

    public Email getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }
}
