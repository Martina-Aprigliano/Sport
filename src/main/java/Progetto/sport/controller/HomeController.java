package Progetto.sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	
	@PostMapping("/newGame")
	public String newGame() {
		System.out.println("GIOCO INSERITO NEL DB");
		return "redirect:/";

	}
}
