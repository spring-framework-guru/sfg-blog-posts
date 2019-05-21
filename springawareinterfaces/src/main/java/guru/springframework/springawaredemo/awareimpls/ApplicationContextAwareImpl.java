package guru.springframework.springawaredemo.awareimpls;

import guru.springframework.springawaredemo.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareImpl implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        User user = (User) applicationContext.getBean("user");
        System.out.println("User Id: " + user.getUserId() + "  User Name :" + user.getName());
    }
}
