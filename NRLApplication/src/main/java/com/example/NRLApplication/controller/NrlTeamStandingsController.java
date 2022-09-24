package com.example.NRLApplication.controller;

import com.example.NRLApplication.dto.NrlTeamStandingsDto;
import com.example.NRLApplication.service.NrlTeamStandingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class NrlTeamStandingsController {


    @Autowired
    public NrlTeamStandingsService nrlTeamStandingsService;

    //getAllStandings
    @GetMapping("/api/standings")
    @ResponseBody
    public List<NrlTeamStandingsDto> getAllStandings() {

        return nrlTeamStandingsService.getAllStandings();
    }

    //Save standings by team name
    @RequestMapping("/api/saveTeamStanding")
    @PostMapping
    public ResponseEntity saveTeamStandings(@RequestBody NrlTeamStandingsDto nrlTeamStandingsDto) {

        return nrlTeamStandingsService.saveTeamStandings(nrlTeamStandingsDto);
    }

    //update standings by team name
    @RequestMapping("/api/teamName/{teamName}")
    @PostMapping
    public ResponseEntity updateTeamStandingsByTeamName(@PathVariable String teamName, @RequestBody NrlTeamStandingsDto nrlTeamStandingsDto) {

        return ResponseEntity.ok(nrlTeamStandingsService.updateNrlTeamPlayerByPlayerName(nrlTeamStandingsDto));
    }

    //getStandingsByName
    @GetMapping("/api/name/{teamName}")
    @ResponseBody
    public ResponseEntity<NrlTeamStandingsDto> getStandingsByTeamName(@PathVariable String teamName) {

        return ResponseEntity.ok(nrlTeamStandingsService.getStandingsByTeamName(teamName));
    }

    //getStandingsByTeamByes
    @GetMapping("/api/teamByes/{teamByes}")
    @ResponseBody
    public List<NrlTeamStandingsDto> getStandingsBYTeamByes(@PathVariable long teamByes) {

        return nrlTeamStandingsService.getStandingsByTeamByes(teamByes);
    }

    //getStandingsByTeamWins
    @GetMapping("/api/teamWins/{teamWins}")
    @ResponseBody
    public List<NrlTeamStandingsDto> getStandingsByTeamWins(@PathVariable long teamWins) {

        return nrlTeamStandingsService.getStandingsByTeamWins(teamWins);
    }

    //getStandingsByTeamLost
    @GetMapping("/api/teamLost/{teamLost}")
    @ResponseBody
    public List<NrlTeamStandingsDto> getStandingsByTeamLost(@PathVariable long teamLost) {

        return nrlTeamStandingsService.getStandingsByTeamLost(teamLost);
    }

    //getStandingsByTeamTied
    @GetMapping("/api/teamTied/{teamTied}")
    @ResponseBody
    public List<NrlTeamStandingsDto> getStandingsByTeamTied(@PathVariable long teamTied) {

        return nrlTeamStandingsService.getStandingsByTeamTied(teamTied);
    }

    //getStandingsByTeamPoints
    @GetMapping("/api/teamPoints/{teamPoints}")
    @ResponseBody
    public List<NrlTeamStandingsDto> getStandingsByTeamPoints(@PathVariable long teamPoints) {

        return nrlTeamStandingsService.getStandingsByTeamPoints(teamPoints);
    }

    //getStandingsByTeamNumberOfMatchesPlayed
    @GetMapping("/api/teamMatches/{teamNumberOfMatchesPlayed}")
    @ResponseBody
    public List<NrlTeamStandingsDto> getStandingsByTeamNumberOfMatchesPlayed(@PathVariable long teamNumberOfMatchesPlayed) {

        return nrlTeamStandingsService.getStandingsByTeamNumberOfMatchesPlayed(teamNumberOfMatchesPlayed);
    }
}