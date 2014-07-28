package com.lsn.cont;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println(1111);
		System.out.println("helloworld");
		System.out.println("hai");


		System.out.println("djdsjlds");
		System.out.println("imageUrl");

		System.out.println("nagarjuna");


		System.out.println("nagarjuna");

		

		System.out.println("ch");


		System.out.println("chiru");

		return "home";
	}
	public void show()
	{
		System.out.println("the output is printed");
	}
	
}
