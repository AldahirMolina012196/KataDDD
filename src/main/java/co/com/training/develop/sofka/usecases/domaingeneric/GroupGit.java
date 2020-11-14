package co.com.training.develop.sofka.usecases.domaingeneric;

import co.com.sofka.domain.generic.ValueObject;
import co.com.training.develop.sofka.usecases.aggregate.clan.valueobjects.Path;

import java.util.Objects;

public class GroupGit implements ValueObject<GroupGit.Props> {
  private final Integer groupId;
  private final Path path;
  private final Name name;

  public GroupGit(Integer groupId, Path path, Name name) {
    this.groupId = Objects.requireNonNull(groupId, "El groupId no puede ser null");
    this.path = Objects.requireNonNull(path,"El path no puede ser null");
    this.name = Objects.requireNonNull(name, "El nombre no puede ser null");
  }

  @Override
  public Props value() {
    return new Props() {
      @Override
      public Integer groupId() {
        return groupId;
      }

      @Override
      public Path path() {
        return path;
      }

      @Override
      public Name name() {
        return name;
      }
    };
  }

  public interface Props{
    Integer groupId();
    Path path();
    Name name();
  }
}
