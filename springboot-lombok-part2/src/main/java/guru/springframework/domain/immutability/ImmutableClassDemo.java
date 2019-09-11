package guru.springframework.domain.immutability;

import lombok.Value;

@Value
public class ImmutableClassDemo {
    String name;
    double score;

    public String getMessage(String msg){
        return "Test "+msg;

    }
}
