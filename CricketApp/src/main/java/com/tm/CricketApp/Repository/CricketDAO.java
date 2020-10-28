package com.tm.CricketApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.CricketApp.Beans.Players;

public interface CricketDAO extends JpaRepository<Players, Integer> {

}
