package pl.pja.edu.hackathon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@GetMapping({"/", "home"})
	public String getHome() {
		return "home";
	}
}