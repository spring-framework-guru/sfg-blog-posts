package guru.springframework.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "memes")
@Getter
@Setter
public class MemeMaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int memeId;
    private String memeMaker;
    private String memeLevel;
    private String memeCategory;

    public MemeMaker() {
    }

    public MemeMaker(String memeMaker, String memeLevel, String memeCategory) {
        this.memeMaker = memeMaker;
        this.memeLevel = memeLevel;
        this.memeCategory = memeCategory;
    }
}





