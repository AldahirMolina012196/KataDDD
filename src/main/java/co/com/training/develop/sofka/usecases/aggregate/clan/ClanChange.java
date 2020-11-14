package co.com.training.develop.sofka.usecases.aggregate.clan;

import co.com.sofka.domain.generic.EventChange;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.AddedMember;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.CreatedClan;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.UpdateScoreMember;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Color;

public class ClanChange extends EventChange {
    public ClanChange(Clan clan){
        apply((CreatedClan event) ->{
            clan.groupGit = event.getGroupGit();
            clan.name = event.getName();
            clan.color = new Color("white");
            clan.members = event.getListMember();
        });

        apply((AddedMember event) ->{
            clan.members.add(new Member(
                    event.getMemberId(), event.getName(),event.getGender(),true,event.getPersonId(),
                    event.getMemberGit(),event.getEmail(),event.getListScore()));
        });

        apply((UpdateScoreMember event) ->{
            for(Member mem : clan.members){
                if(mem.identity().equals(event.getMemberId())){
                    mem.listScore.add(event.getScore());
                }
            }
        });
    }
}
