package guru.springframework.domain.notnull;

import javax.validation.constraints.NotNull;

public class NotNullUserDemo {
    private int userId;
    private String userName;
    private int userAge;

    /*
        @NotNull generates a null-check statement
    */

    public NotNullUserDemo(@NotNull int userId, String userName, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
    }
}
