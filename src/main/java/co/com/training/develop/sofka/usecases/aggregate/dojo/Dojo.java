package co.com.training.develop.sofka.usecases.aggregate.dojo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.training.develop.sofka.usecases.aggregate.clan.events.UpdateScoreMember;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.MemberId;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Score;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.AddedRule;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.AssignedSensei;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.ChangedLocation;
import co.com.training.develop.sofka.usecases.aggregate.dojo.events.CreatedDojo;
import co.com.training.develop.sofka.usecases.aggregate.dojo.valueobjects.*;
import co.com.training.develop.sofka.usecases.domaingeneric.GroupGit;
import co.com.training.develop.sofka.usecases.domaingeneric.MemberGit;
import co.com.training.develop.sofka.usecases.domaingeneric.Name;
import co.com.training.develop.sofka.usecases.domaingeneric.PersonId;

import java.util.List;

public class Dojo extends AggregateEvent<DojoId> {
   protected Sensei sensei;
   protected DataInfo dataInfo;
   protected Status status;
   protected List<Rule> rules;
   protected GroupGit groupGit;
   protected Location location;

   public Dojo(DojoId dojoId, DataInfo dataInfo, GroupGit groupGit, Location location) {
      super(dojoId);
      appendChange(new CreatedDojo(dojoId,dataInfo,groupGit,location)).apply();
   }

   private Dojo(DojoId dojoId){
      super(dojoId);
      subscribe(new DojoChange(this));
   }

   public static  Dojo from(DojoId dojoId, List<DomainEvent> events){
      var dojo = new Dojo(dojoId);
      events.forEach(dojo::applyEvent);
      return dojo;
   }

   public void assignSensei(SenseiId senseiId, Name name, PersonId personId, Speciality speciality, MemberGit memberGit, List<Accomplishment> accomplishments){
      appendChange(new AssignedSensei(senseiId,name,personId,speciality,memberGit,accomplishments)).apply();
   }

   public void addRule(Rule rule){
      appendChange(new AddedRule(rule)).apply();
   }

   public void changeLocation(String urlMeetChange){
      appendChange(new ChangedLocation(urlMeetChange)).apply();
   }

   public void evaluateClan(DojoId dojoId, MemberId memberId, Score score){
      appendChange(new UpdateScoreMember(dojoId,memberId,score)).apply();
   }

}
