package guru.springframework.domain.valandvar;

import java.math.BigDecimal;
import java.util.ArrayList;

import lombok.val;


public class ValAndVarUserDemo {
    public String valCheck() {
        /*
        val makes local final variable (inside method)
        Trying to assign a value will result in Error: java: cannot assign a value to final variable userName
        */
        val userName = "Hello World";
        System.out.println(userName.getClass());
        return userName.toLowerCase();
    }

    public Object varCheck() {
         /*
          var makes local variable (inside method). Same as var but is not marked final
        */
        var money = new BigDecimal(53.00);
        System.out.println(money.getClass());
        money=new BigDecimal(80.00);
        return money;
    }
}
