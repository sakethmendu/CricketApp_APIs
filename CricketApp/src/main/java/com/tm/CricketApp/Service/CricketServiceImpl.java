package com.tm.CricketApp.Service;


import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tm.CricketApp.Beans.Players;
import com.tm.CricketApp.Repository.CricketDAO;

@Service
public class CricketServiceImpl implements CricketService {

	@Autowired
	private CricketDAO cricketDAO;

	public List<Players> getAllPLayers() {
		return cricketDAO.findAll();
	}
	
	public Players getPlayerById(int playerId) {
		Optional<Players> result = cricketDAO.findById(playerId);
		Players player = null;
		if (result.isPresent()) {
			player = result.get();

		}
		return player;
	}

	public void createPlayer(Players thePlayer) {
		cricketDAO.save(thePlayer);
	}

	public void deletePlayerById(int playerId) {
		cricketDAO.deleteById(playerId);
	}

}
