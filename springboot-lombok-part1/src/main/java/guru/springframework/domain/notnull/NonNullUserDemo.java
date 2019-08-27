package guru.springframework.domain.notnull;


import lombok.NonNull;




public class NonNullUserDemo {
    private int userId;
    private String userName;
    private int userAge;

    /*
        @NotNull generates a null-check statement
    */

    public NonNullUserDemo(int userId, @NonNull String userName, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
    }
}
