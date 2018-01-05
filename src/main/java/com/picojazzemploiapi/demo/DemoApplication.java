package com.picojazzemploiapi.demo;

import com.picojazzemploiapi.demo.dao.CvRepository;
import com.picojazzemploiapi.demo.dao.OfferRepository;
import com.picojazzemploiapi.demo.dao.UserRepository;

import com.picojazzemploiapi.demo.entities.Cv;
import com.picojazzemploiapi.demo.entities.Offer;
import com.picojazzemploiapi.demo.entities.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx =
				SpringApplication.run(DemoApplication.class, args);
		OfferRepository or = ctx.getBean(OfferRepository.class);
		for (int i = 0 ; i < 10 ; i++) {
			or.save(new Offer("Développeur Fullstack Java Angular 4 H/F", "Dans le cadre de la refonte de son portail assurance vie et prévoyance, notre client recherche un développeur expérimenté H/F \n" +
					"\n" +
					"Vos principales missions consisteront à :\n" +
					"Participation aux spécifications techniques et fonctionnelles\n" +
					"Participation aux développements en J2EE\n" +
					"Rédaction des plans de test de qualification\n" +
					"Réalisation des cas\n" +
					"Déploiement\n" +
					"Assistance recette et MEOP\n" +
					"Profil recherché \n" +
					"\n" +
					"D’une formation informatique de niveau Bac +4/5 (Ecole d’ingénieur, commerce ou Université), vous justifiez d’une expérience d’au moins 5 ans dans ce poste. La connaissance des métiers de l’assurance est un plus. \n" +
					"\n" +
					"Vous maîtrisez également :\n" +
					"Design simple\n" +
					"Conception et code Object\n" +
					"Techniques de testing (TDD, BDD)\n" +
					"Clean code\n" +
					"Vous appréciez le travail en équipe et dans un environnement agile.\n" +
					"il y a 1 heure - sauvegarder - voir l'offre d'origine", "dakar", -17.4730629, 14.7115395, "cdi", 6000000, "2017-12-27", "Sonatel Senegal"));
		}

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