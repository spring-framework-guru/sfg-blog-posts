package guru.springframework.springawaredemo.awareimpls;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNameAwareImpl implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println("Bean Name: " + s);
    }
}
