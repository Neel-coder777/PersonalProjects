package com.example.NRLApplication.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "nrl_players")
public class NrlTeamPlayers {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "player_name")
    private String playerName;//check

    @Column(name = "player_team")
    private String playerTeam;//check

    @Column(name = "player_position")
    private String playerPosition;//check

    @Column(name = "player_number")
    private long playerNumber;//check

    @Column(name = "player_tries")
    private long playerTries;

    @Column(name = "player_assists")
    private long playerAssists;

    @Column(name = "player_goals")
    private long playerGoals;

    @Column(name = "player_field_goals")
    private long playerFieldGoals;

    @Column(name = "player_two_point_field_goals")
    private long playerTwoPointFieldGoals;
}