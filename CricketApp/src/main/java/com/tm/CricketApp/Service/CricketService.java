package com.tm.CricketApp.Service;

import java.util.List;

import com.tm.CricketApp.Beans.Players;

public interface CricketService {

	public List<Players> getAllPLayers();

	public Players getPlayerById(int theId);

	public void createPlayer(Players thePlayer);

	public void deletePlayerById(int playerId);

}
