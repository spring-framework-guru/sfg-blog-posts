package com.blog.post.dependencyInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TutorialApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfiguration.class);
		MyService myServiceImpl= (MyService) ctx.getBean("myServiceImpl");
    	 myServiceImpl.storeInDb();

    }

}
