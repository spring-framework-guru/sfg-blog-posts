package guru.springframework.debug.idea;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DebugExampleTwo {

    @Getter
    public static class Container {
        private Integer value;
    }

    private List<Container> containers = new ArrayList<>(10);

    public DebugExampleTwo() {
        for (int i = 0; i < 10; i++) {
            if (i % 5 != 0) {
                Container container = new Container();
                container.value = i;

                containers.add(container);
            }
        }
    }
}
