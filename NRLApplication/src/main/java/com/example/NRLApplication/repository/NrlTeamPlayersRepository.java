package com.example.NRLApplication.repository;

import com.example.NRLApplication.model.NrlTeamPlayers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NrlTeamPlayersRepository extends JpaRepository<NrlTeamPlayers, Long> {

    NrlTeamPlayers findPlayerByPlayerName(String playerName);

    List<NrlTeamPlayers> findPlayersByPlayerTeam(String playerTeam);

    List<NrlTeamPlayers> findPlayerByPlayerPosition(String playerPosition);

    List<NrlTeamPlayers> findPlayersByPlayerNumber(long playerNumber);
}