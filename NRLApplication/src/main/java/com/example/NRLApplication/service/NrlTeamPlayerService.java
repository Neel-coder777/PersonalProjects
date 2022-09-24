package com.example.NRLApplication.service;

import com.example.NRLApplication.dto.NrlTeamPlayersDto;
import com.example.NRLApplication.model.NrlTeamPlayers;
import com.example.NRLApplication.repository.NrlTeamPlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NrlTeamPlayerService {

    @Autowired
    public NrlTeamPlayersRepository nrlTeamPlayersRepository;

    public NrlTeamPlayerService(NrlTeamPlayersRepository nrlTeamPlayersRepository) {

        this.nrlTeamPlayersRepository = nrlTeamPlayersRepository;
    }

    /*****************************************Save*****************************************/

    //savePlayer
    public ResponseEntity savePlayer(NrlTeamPlayersDto dto) {

        NrlTeamPlayers player = new NrlTeamPlayers();

        player.setPlayerName(dto.getPlayerName());
        player.setPlayerTeam(dto.getPlayerTeam());
        player.setPlayerPosition(dto.getPlayerPosition());
        player.setPlayerNumber(dto.getPlayerNumber());
        player.setPlayerTries(dto.getPlayerTries());
        player.setPlayerAssists(dto.getPlayerAssists());
        player.setPlayerGoals(dto.getPlayerGoals());
        player.setPlayerFieldGoals(dto.getPlayerFieldGoals());
        player.setPlayerTwoPointFieldGoals(dto.getPlayerTwoPointFieldGoals());

        nrlTeamPlayersRepository.save(player);

        return ResponseEntity.ok(dto);
    }

    /*****************************************Update*****************************************/

    //updateStandingsByPlayerName
    public ResponseEntity updatePlayer(NrlTeamPlayersDto dto, String playerName) {

        NrlTeamPlayers player = nrlTeamPlayersRepository.findPlayerByPlayerName(playerName);

        player.setPlayerName(dto.getPlayerName());
        player.setPlayerTeam(dto.getPlayerTeam());
        player.setPlayerPosition(dto.getPlayerPosition());
        player.setPlayerNumber(dto.getPlayerNumber());
        player.setPlayerTries(dto.getPlayerTries());
        player.setPlayerAssists(dto.getPlayerAssists());
        player.setPlayerGoals(dto.getPlayerGoals());
        player.setPlayerFieldGoals(dto.getPlayerFieldGoals());
        player.setPlayerTwoPointFieldGoals(dto.getPlayerTwoPointFieldGoals());

        nrlTeamPlayersRepository.save(player);

        return ResponseEntity.ok(dto);
    }

    /*****************************************Get*****************************************/

    //getAllPlayers
    public List<NrlTeamPlayersDto> getAllPlayers() {

        List<NrlTeamPlayersDto> toReturn = new ArrayList<>();

        List<NrlTeamPlayers> nrlTeamPlayers = nrlTeamPlayersRepository.findAll();

        for (NrlTeamPlayers players : nrlTeamPlayers) {

            NrlTeamPlayersDto dto = new NrlTeamPlayersDto();

            dto.setId(players.getId());
            dto.setPlayerName(players.getPlayerName());
            dto.setPlayerTeam(players.getPlayerTeam());
            dto.setPlayerPosition(players.getPlayerPosition());
            dto.setPlayerNumber(players.getPlayerNumber());
            dto.setPlayerTries(players.getPlayerTries());
            dto.setPlayerAssists(players.getPlayerAssists());
            dto.setPlayerGoals(players.getPlayerGoals());
            dto.setPlayerFieldGoals(players.getPlayerFieldGoals());
            dto.setPlayerTwoPointFieldGoals(players.getPlayerTwoPointFieldGoals());

            toReturn.add(dto);
        }

        return toReturn;
    }

    //getPlayersByTeamName
    public List<NrlTeamPlayersDto> getPlayersByPlayerTeam(String playerTeam) {

        List<NrlTeamPlayersDto> toReturn = new ArrayList<>();

        List<NrlTeamPlayers> nrlTeamPlayers = nrlTeamPlayersRepository.findPlayersByPlayerTeam(playerTeam);

        for (NrlTeamPlayers players : nrlTeamPlayers) {

            NrlTeamPlayersDto dto = new NrlTeamPlayersDto();

            dto.setId(players.getId());
            dto.setPlayerName(players.getPlayerName());
            dto.setPlayerTeam(players.getPlayerTeam());
            dto.setPlayerPosition(players.getPlayerPosition());
            dto.setPlayerNumber(players.getPlayerNumber());
            dto.setPlayerTries(players.getPlayerTries());
            dto.setPlayerAssists(players.getPlayerAssists());
            dto.setPlayerGoals(players.getPlayerGoals());
            dto.setPlayerFieldGoals(players.getPlayerFieldGoals());
            dto.setPlayerTwoPointFieldGoals(players.getPlayerTwoPointFieldGoals());

            toReturn.add(dto);
        }

        return toReturn;
    }

    //getPlayersByPlayerPosition
    public List<NrlTeamPlayersDto> getPlayersByPlayerPosition(String playerPosition) {

        List<NrlTeamPlayersDto> toReturn = new ArrayList<>();

        List<NrlTeamPlayers> nrlTeamPlayers = nrlTeamPlayersRepository.findPlayerByPlayerPosition(playerPosition);

        for (NrlTeamPlayers players : nrlTeamPlayers) {

            NrlTeamPlayersDto dto = new NrlTeamPlayersDto();

            dto.setId(players.getId());
            dto.setPlayerName(players.getPlayerName());
            dto.setPlayerTeam(players.getPlayerTeam());
            dto.setPlayerPosition(players.getPlayerPosition());
            dto.setPlayerNumber(players.getPlayerNumber());
            dto.setPlayerTries(players.getPlayerTries());
            dto.setPlayerAssists(players.getPlayerAssists());
            dto.setPlayerGoals(players.getPlayerGoals());
            dto.setPlayerFieldGoals(players.getPlayerFieldGoals());
            dto.setPlayerTwoPointFieldGoals(players.getPlayerTwoPointFieldGoals());

            toReturn.add(dto);
        }

        return toReturn;
    }

    public List<NrlTeamPlayersDto> getPlayersByPlayerNumber(long playerNumber) {

        List<NrlTeamPlayersDto> toReturn = new ArrayList<>();

        List<NrlTeamPlayers> nrlTeamPlayers = nrlTeamPlayersRepository.findPlayersByPlayerNumber(playerNumber);

        for (NrlTeamPlayers players : nrlTeamPlayers) {

            NrlTeamPlayersDto dto = new NrlTeamPlayersDto();

            dto.setId(players.getId());
            dto.setPlayerName(players.getPlayerName());
            dto.setPlayerTeam(players.getPlayerTeam());
            dto.setPlayerPosition(players.getPlayerPosition());
            dto.setPlayerNumber(players.getPlayerNumber());
            dto.setPlayerTries(players.getPlayerTries());
            dto.setPlayerAssists(players.getPlayerAssists());
            dto.setPlayerGoals(players.getPlayerGoals());
            dto.setPlayerFieldGoals(players.getPlayerFieldGoals());
            dto.setPlayerTwoPointFieldGoals(players.getPlayerTwoPointFieldGoals());

            toReturn.add(dto);
        }

        return toReturn;
    }

    //getPlayerByPlayerName
    public NrlTeamPlayersDto getPlayerByPlayerName(String playerName) {

        NrlTeamPlayersDto toReturn = new NrlTeamPlayersDto();

        NrlTeamPlayers nrlTeamPlayers = nrlTeamPlayersRepository.findPlayerByPlayerName(playerName);

        toReturn.setId(nrlTeamPlayers.getId());
        toReturn.setPlayerName(nrlTeamPlayers.getPlayerName());
        toReturn.setPlayerTeam(nrlTeamPlayers.getPlayerTeam());
        toReturn.setPlayerPosition(nrlTeamPlayers.getPlayerPosition());
        toReturn.setPlayerNumber(nrlTeamPlayers.getPlayerNumber());
        toReturn.setPlayerTries(nrlTeamPlayers.getPlayerTries());
        toReturn.setPlayerAssists(nrlTeamPlayers.getPlayerAssists());
        toReturn.setPlayerGoals(nrlTeamPlayers.getPlayerGoals());
        toReturn.setPlayerFieldGoals(nrlTeamPlayers.getPlayerFieldGoals());
        toReturn.setPlayerTwoPointFieldGoals(nrlTeamPlayers.getPlayerTwoPointFieldGoals());

        return toReturn;
    }
}