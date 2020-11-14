package co.com.training.develop.sofka.usecases.domaingeneric;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MemberGit implements ValueObject<MemberGit.Props> {
    private final Integer memberGitId;
    private final String imageAvatarUrl;
    private final String userName;

    public MemberGit(Integer memberGitId, String imageAvatarUrl, String userName) {
        this.memberGitId = Objects.requireNonNull(memberGitId,"MemberGitId no puede ser null");
        this.imageAvatarUrl = Objects.requireNonNull(imageAvatarUrl,"ImageAvatarUrl no puede ser null");
        this.userName = Objects.requireNonNull(userName,"El userName no puede ser ull");
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer memberGitId() {
                return memberGitId;
            }

            @Override
            public String imageAvatarUrl() {
                return imageAvatarUrl;
            }

            @Override
            public String userName() {
                return userName;
            }
        };
    }


    public interface Props{
        Integer memberGitId();
        String imageAvatarUrl();
        String userName();
    }
}
