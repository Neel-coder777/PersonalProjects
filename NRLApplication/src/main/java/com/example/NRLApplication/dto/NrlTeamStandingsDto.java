package com.example.NRLApplication.dto;

import lombok.Data;

@Data
public class NrlTeamStandingsDto {

    public long id;

    private String teamName;

    private long teamPosition;

    private long teamNumberOfMatchesPlayed;

    private long teamPoints;

    private long teamWins;

    private long teamLost;

    private long teamTied;

    private long teamDifference;

    public long teamByes;
}
