package com.example.NRLApplication.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class NrlTeamPlayersDto {

    private long id;

    private String playerName;

    private String playerTeam;

    private String playerPosition;

    private long playerNumber;

    private long playerTries;

    private long playerAssists;

    private long playerGoals;

    private long playerFieldGoals;

    private long playerTwoPointFieldGoals;

}
