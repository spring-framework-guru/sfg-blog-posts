package guru.springframework.domain.valandvar;

import java.util.ArrayList;

import lombok.val;

public class ValAndVarUserDemo {
    public String valCheck() {
        /*
        val makes local final variable (inside method)
        */
        val list = new ArrayList<String>();
        list.add("Example of Val");
        val getElement = list.get(0);
        return getElement.toLowerCase();
    }

    public String varCheck() {
         /*
          val makes local variable (inside method)
        */
        var list = new ArrayList<String>();
        list.add("Example of Var");
        var getElement = list.get(0);
        return getElement.toLowerCase();
    }
}
