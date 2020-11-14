package co.com.training.develop.sofka.usecases.aggregate.clan.commands;

import co.com.sofka.domain.generic.Command;
import co.com.training.develop.sofka.usecases.aggregate.clan.Member;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.*;

import java.util.List;

public class CreateClanCommand implements Command {
    private ClanId clanId;
    private GroupGit groupGit;
    private Name nameClan;
    private List<Member> listMembers;

    private Name nameMember;
    private MemberId memberId;
    private Gender gender;
    private PersonId personId;
    private MemberGit memberGit;
    private Email email;
    private List<Score> listScore;

    public CreateClanCommand() {
    }

    public CreateClanCommand(ClanId clanId, GroupGit groupGit, Name nameClan,
                             List<Member> listMembers, Name nameMember, MemberId memberId,
                             Gender gender, PersonId personId, MemberGit memberGit, Email email, List<Score> listScore) {
        this.clanId = clanId;
        this.groupGit = groupGit;
        this.nameClan = nameClan;
        this.listMembers = listMembers;
        this.nameMember = nameMember;
        this.memberId = memberId;
        this.gender = gender;
        this.personId = personId;
        this.memberGit = memberGit;
        this.email = email;
        this.listScore = listScore;
    }

    public ClanId getClanId() {
        return clanId;
    }

    public void setClanId(ClanId clanId) {
        this.clanId = clanId;
    }

    public GroupGit getGroupGit() {
        return groupGit;
    }

    public void setGroupGit(GroupGit groupGit) {
        this.groupGit = groupGit;
    }

    public Name getNameClan() {
        return nameClan;
    }

    public Name getNameMember() {
        return nameMember;
    }

    public List<Score> getListScore() {
        return listScore;
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public void setMemberId(MemberId memberId) {
        this.memberId = memberId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public void setPersonId(PersonId personId) {
        this.personId = personId;
    }

    public MemberGit getMemberGit() {
        return memberGit;
    }

    public void setMemberGit(MemberGit memberGit) {
        this.memberGit = memberGit;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setNameClan(Name nameClan) {
        this.nameClan = nameClan;
    }

    public List<Member> getListMembers() {
        return listMembers;
    }

    public void setListMembers(List<Member> listMembers) {
        this.listMembers = listMembers;
    }

    public void setNameMember(Name nameMember) {
        this.nameMember = nameMember;
    }

    public void setListScore(List<Score> listScore) {
        this.listScore = listScore;
    }
}
