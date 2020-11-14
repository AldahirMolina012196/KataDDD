package co.com.training.develop.sofka.usecases.aggregate.clan;

import co.com.sofka.domain.generic.Entity;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Email;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Gender;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.MemberId;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Score;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;

import java.util.List;


public class Member extends Entity<MemberId> {
    protected Name name;
    protected Gender gender;
    protected Boolean isOwner;
    protected PersonId personId;
    protected MemberGit memberGit;
    protected Email email;
    protected List<Score> listScore;

    public Member(MemberId entityId, Name name, Gender gender, Boolean isOwner, PersonId personId, MemberGit memberGit, Email email, List<Score> listScore) {
        super(entityId);
        this.name = name;
        this.gender = gender;
        this.isOwner = isOwner;
        this.personId = personId;
        this.memberGit = memberGit;
        this.email = email;
        this.listScore = listScore;
    }

    public Name name() {
        return name;
    }

    public Gender gender() {
        return gender;
    }

    public Boolean owner() {
        return isOwner;
    }

    public PersonId personId() {
        return personId;
    }

    public MemberGit memberGit() {
        return memberGit;
    }

    public Email email() {
        return email;
    }

    public List<Score> listScore() {
        return listScore;
    }
}
