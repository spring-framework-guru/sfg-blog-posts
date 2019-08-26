package guru.springframework.domain.val;

import java.util.ArrayList;

import guru.springframework.SpringBootLombokApplication;
import lombok.val;
import org.springframework.boot.SpringApplication;

public class ValUserDemo {
    public String valExample() {
        val list = new ArrayList<String>();
        list.add("Example of Val");
        val getElement = list.get(0);
        return getElement.toLowerCase();
    }
}
