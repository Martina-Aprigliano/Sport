package Progetto.sport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MatchController {

	@Controller
	@RequestMapping("/match")
	public class GameController {

		// Apriamo la pagina del gioco scelto, avendo quindi un parametro in
		// input che dalla pagina home che ci dice quale gioco aprire e con quali
		@GetMapping("/")
		public String openGame(@RequestParam("id") String idGames, Model model) {
			model.addAttribute("nomeGame", idGames);
			return "game.html";
		}

		// modale per inserire un nuovo team 
		@PostMapping("/addTeam")
		public String addNewTeam() {
			System.out.println("TEAM INSERITO NEL DB");
			return "redirect:/game/";
		}

		// modale per inserire un nuovo match 
		@PostMapping("/addMatch")
		public String addNewMatch() {
			System.out.println("MATCH INSERITO NEL DB");
			return "redirect:/game/";
		}




	}

}
