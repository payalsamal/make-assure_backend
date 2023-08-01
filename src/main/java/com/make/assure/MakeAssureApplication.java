package com.make.assure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableTransactionManagement
@CrossOrigin(origins = "http://localhost:3000") 
public class MakeAssureApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(MakeAssureApplication.class, args);
//	UserInFoDao userInFoDao=context.getBean(UserInFoDao.class);
//	Iterable<UserInfo>data=userInFoDao.findAll();
//	UserInfo user=new UserInfo();
//	user.setFirstName("jenny1");
//	
//			//(null, "jenny1", "test", "jenny@makeassure.com", null, null, 1, null, 0, null, 0);
//	userInFoDao.save(user);
//	System.out.println(data);
//	
	}

}
