package springframework.domain.builder;

import lombok.*;

@Data
@Builder
public class BuilderUserDemo {
    private int userId;
    private String userName;
    private int userAge;
}
