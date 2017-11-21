package com.picojazzemploiapi.demo;

import com.picojazzemploiapi.demo.dao.UserRepository;
import com.picojazzemploiapi.demo.entities.User;
import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		UserRepository ur = ctx.getBean(UserRepository.class);
		ur.save(new Users("picojazz","amadou","picojazzz@gmail.com"));
	}
}
@Controller
class controller{
	@GetMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello world !";
	}
}