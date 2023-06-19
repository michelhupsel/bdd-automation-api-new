package bdd.automation.api.support.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
public class User {
    @Builder.Default
    private int id = 10;
    @Builder.Default
    private String username = "michelsilva";
    @Builder.Default
    private String firstName = "Michel";
    @Builder.Default
    private String lastName = "Silva";
    @Builder.Default
    private String email = "michel@gmail.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "99888885555";
    @Builder.Default
    private int userStatus = 1;
}
