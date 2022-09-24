package com.example.NRLApplication.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "nrl_team_standings")
public class NrlTeamStandings {

    @Id
    @GeneratedValue
    public long id;

    @Column(name = "team_name")
    private String teamName;//check

    @Column(name = "team_position")
    private long teamPosition;

    @Column(name = "team_number_of_matches_played")
    private long teamNumberOfMatchesPlayed;

    @Column(name = "team_points")
    private long teamPoints;//check

    @Column(name = "team_wins")
    private long teamWins;//check

    @Column(name = "team_lost")
    private long teamLost;//check

    @Column(name = "team_tied")
    private long teamTied;//check

    @Column(name = "team_difference")
    private long teamDifference;

    @Column(name = "team_byes")
    private long teamByes;//check
}
