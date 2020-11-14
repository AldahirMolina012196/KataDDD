package co.com.training.develop.sofka.usecases.aggregate.clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.clan.Member;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.ClanId;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;

import java.util.List;

public class CreatedClan extends DomainEvent {
    private final ClanId clanId;
    private final GroupGit groupGit;
    private final Name name;
    private final List<Member> listMember;

    public CreatedClan(ClanId clanId, GroupGit groupGit, Name name, List<Member> listMember) {
        super("clan.events.CreatedClan");
        this.clanId = clanId;
        this.groupGit = groupGit;
        this.name = name;
        this.listMember = listMember;
    }

    public ClanId getClanId() {
        return clanId;
    }

    public GroupGit getGroupGit() {
        return groupGit;
    }

    public Name getName() {
        return name;
    }

    public List<Member> getListMember() {
        return listMember;
    }
}
