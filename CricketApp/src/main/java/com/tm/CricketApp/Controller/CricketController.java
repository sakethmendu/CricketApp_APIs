package com.tm.CricketApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.CricketApp.Beans.Players;
import com.tm.CricketApp.Repository.CricketDAO;
import com.tm.CricketApp.Service.CricketService;

@RestController
@CrossOrigin(origins="*")  
@RequestMapping("/cricket/api")
public class CricketController {

	@Autowired
	private CricketService cricketService;
	
	@Autowired
	private CricketDAO cricketData;

	@GetMapping("/players")
	public List<Players> geAlltPlayers() {
		return cricketService.getAllPLayers();
	}
	
	@GetMapping("/players/page")
	Page<Players> employeesPageable(Pageable pageable) {
		return cricketData.findAll(pageable);

	}
	

	@GetMapping("/players/{playerId}")
	public Players getPlayerById(@PathVariable int playerId) {
		Players player = cricketService.getPlayerById(playerId);
		if (player == null) {
			throw new RuntimeException("Player not found with this ID:" + playerId);
		}
		return player;
	}

	@PostMapping("/players")
	public Players createPlayer(@RequestBody Players thePlayer) {
		cricketService.createPlayer(thePlayer);
		return thePlayer;
	}

	@DeleteMapping("/players/{playerId}")
	public String deletePlayerById(@PathVariable int playerId) {
		Players tempPlayer = cricketService.getPlayerById(playerId);
		if (tempPlayer == null) {
			throw new RuntimeException("Did not find the player by id -" + playerId);
		}
		cricketService.deletePlayerById(playerId);
		return "Deleted Player id - " + playerId;
	}

	@PatchMapping("/players")
	public Players updatePlayer(@RequestBody Players thePlayer) {
		cricketService.createPlayer(thePlayer);
		return thePlayer;
	}

}
