package com.picojazzemploiapi.demo;

import com.picojazzemploiapi.demo.dao.CvRepository;
import com.picojazzemploiapi.demo.dao.UserRepository;

import com.picojazzemploiapi.demo.entities.Cv;
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

		//ApplicationContext ctx =
				SpringApplication.run(DemoApplication.class, args);
		/*UserRepository ur = ctx.getBean(UserRepository.class);
		CvRepository cvr = ctx.getBean(CvRepository.class);
		Cv cv = new Cv(ur.findOne(new Long(2)));
		cv.setEmail("cv de pp");
		cvr.save(cv);
		System.out.println(ur.findOne(new Long(2)).toString());*/

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