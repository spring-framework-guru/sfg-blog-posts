package guru.springframework.domain.gettersetter;

import lombok.Getter;
import lombok.Setter;

public class FieldLevelGetterSetterDemo {

        private int userId;
        @Getter @Setter
        private String userName;
        @Getter
        private int userAge;
        public FieldLevelGetterSetterDemo(int userAge){
                this.userAge=userAge;
        }

}
