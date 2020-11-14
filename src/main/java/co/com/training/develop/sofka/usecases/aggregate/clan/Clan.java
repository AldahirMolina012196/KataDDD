package co.com.training.develop.sofka.usecases.aggregate.clan;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.AddedMember;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.CreatedClan;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.*;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;

import java.util.List;

public class Clan extends AggregateEvent<ClanId> {
    protected List<Member> members;
    protected GroupGit groupGit;
    protected Color color;
    protected Name name;

    public Clan(ClanId clanId, GroupGit groupGit, Name name, List<Member> listMembers) {
        super(clanId);
        appendChange(new CreatedClan(clanId, groupGit,name, listMembers)).apply();
    }

    public static Clan from(ClanId clanId, List<DomainEvent> events){
        var clan = new Clan(clanId);
        events.forEach(clan::applyEvent);
        return clan;
    }

    private Clan(ClanId clanId){
        super(clanId);
        subscribe(new ClanChange(this));
    }

    public void addNewMember(Name name, MemberId memberId, Gender gender, PersonId personId, MemberGit memberGit, Email email, List<Score> listScore){
        appendChange(new AddedMember(name, memberId,gender,personId,memberGit,email, listScore)).apply();
    }

}
