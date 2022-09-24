package com.example.NRLApplication.repository;

import com.example.NRLApplication.dto.NrlTeamStandingsDto;
import com.example.NRLApplication.model.NrlTeamStandings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NrlTeamStandingsRepository extends JpaRepository<NrlTeamStandings, Long> {

        NrlTeamStandings findTeamStandingsByTeamName(String teamName);

        List<NrlTeamStandings> findTeamStandingsByTeamByes(long teamByes);

        List<NrlTeamStandings> findTeamStandingsByTeamWins(long teamWins);

        List<NrlTeamStandings> findTeamStandingsByTeamLost(long teamLost);

        List<NrlTeamStandings> findTeamStandingsByTeamTied(long teamTied);

        List<NrlTeamStandings> findTeamStandingsByTeamPoints(long teamPoints);

        List<NrlTeamStandings> findTeamStandingsByTeamNumberOfMatchesPlayed(long teamNumberOfMatchesPlayed);
}