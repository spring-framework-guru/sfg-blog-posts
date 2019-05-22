package com.blog.post.dependencyInjection;

public class BeanWithDependency {

    public MyFirstBean myFirstBean;

    public void setMyFirstBean(MyFirstBean myFirstBean) {
        this.myFirstBean = myFirstBean;
    }

    @Override
    public String toString() {
        return "BeanWithDependency{" +
                "myFirstBean=" + myFirstBean +
                '}';
    }
}
