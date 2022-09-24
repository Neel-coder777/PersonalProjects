package com.example.NRLApplication.service;

import com.example.NRLApplication.dto.NrlTeamPlayersDto;
import com.example.NRLApplication.dto.NrlTeamStandingsDto;
import com.example.NRLApplication.model.NrlTeamPlayers;
import com.example.NRLApplication.model.NrlTeamStandings;
import com.example.NRLApplication.repository.NrlTeamStandingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NrlTeamStandingsService {

    @Autowired
    public NrlTeamStandingsRepository nrlTeamStandingsRepository;

    private Map<String, NrlTeamStandingsDto> NrlTeamStandingsCache = new HashMap<>();

    public NrlTeamStandingsService(NrlTeamStandingsRepository nrlTeamStandingsRepository) {

        this.nrlTeamStandingsRepository = nrlTeamStandingsRepository;
    }

    /*************************************Update************************************************/
    //update standings by name
    public ResponseEntity updateNrlTeamPlayerByPlayerName(NrlTeamStandingsDto dto) {

        NrlTeamStandings standingsToUpDate = nrlTeamStandingsRepository.findTeamStandingsByTeamName(dto.getTeamName());

        standingsToUpDate.setTeamName(dto.getTeamName());
        standingsToUpDate.setTeamPosition(dto.getTeamPosition());
        standingsToUpDate.setTeamNumberOfMatchesPlayed(dto.getTeamNumberOfMatchesPlayed());
        standingsToUpDate.setTeamPoints(dto.getTeamPoints());
        standingsToUpDate.setTeamWins(dto.getTeamWins());
        standingsToUpDate.setTeamLost(dto.getTeamLost());
        standingsToUpDate.setTeamTied(dto.getTeamTied());
        standingsToUpDate.setTeamDifference(dto.getTeamDifference());
        standingsToUpDate.setTeamByes(dto.getTeamByes());

        nrlTeamStandingsRepository.save(standingsToUpDate);

        return ResponseEntity.ok(dto);
    }

    /*************************************Get************************************************/
    //getStandingsByName
    public NrlTeamStandingsDto getStandingsByTeamName(String teamName) {

        if (!NrlTeamStandingsCache.isEmpty()) {

            System.out.println("HIT THE CACHE !!!");
            return NrlTeamStandingsCache.get(teamName);
        }

        NrlTeamStandings nrlTeamStandings = nrlTeamStandingsRepository.findTeamStandingsByTeamName(teamName);

        NrlTeamStandingsDto toReturn = new NrlTeamStandingsDto();
        toReturn.setId(nrlTeamStandings.getId());
        toReturn.setTeamName(nrlTeamStandings.getTeamName());
        toReturn.setTeamPosition(nrlTeamStandings.getTeamPosition());
        toReturn.setTeamNumberOfMatchesPlayed(nrlTeamStandings.getTeamNumberOfMatchesPlayed());
        toReturn.setTeamPoints(nrlTeamStandings.getTeamPoints());
        toReturn.setTeamWins(nrlTeamStandings.getTeamWins());
        toReturn.setTeamLost(nrlTeamStandings.getTeamLost());
        toReturn.setTeamTied(nrlTeamStandings.getTeamTied());
        toReturn.setTeamDifference(nrlTeamStandings.getTeamDifference());
        toReturn.setTeamByes(nrlTeamStandings.getTeamByes());

        return toReturn;
    }

    //getAllStandings
    public List<NrlTeamStandingsDto> getAllStandings() {


        List<NrlTeamStandingsDto> toReturn = new ArrayList<>();
        List<NrlTeamStandings> nrlTeamStandings = nrlTeamStandingsRepository.findAll();

        for (NrlTeamStandings standings : nrlTeamStandings) {

            NrlTeamStandingsDto dto = new NrlTeamStandingsDto();

                dto.setId(standings.getId());
                dto.setTeamName(standings.getTeamName());
                dto.setTeamPosition(standings.getTeamPosition());
                dto.setTeamNumberOfMatchesPlayed(standings.getTeamNumberOfMatchesPlayed());
                dto.setTeamPoints(standings.getTeamPoints());
                dto.setTeamWins(standings.getTeamWins());
                dto.setTeamLost(standings.getTeamLost());
                dto.setTeamTied(standings.getTeamTied());
                dto.setTeamDifference(standings.getTeamDifference());
                dto.setTeamByes(standings.getTeamByes());

                toReturn.add(dto);

            if (NrlTeamStandingsCache.isEmpty()) {
                toReturn.stream().forEach(nrlTeamStandingsDto -> {

                    NrlTeamStandingsCache.put(nrlTeamStandingsDto.getTeamName(), nrlTeamStandingsDto);
                });
            }

        }

        return toReturn;
    }

    //getStandingsByTeamByes
    public List<NrlTeamStandingsDto> getStandingsByTeamByes(long teamByes) {

        List<NrlTeamStandingsDto> toReturn = new ArrayList<>();
        List<NrlTeamStandings> nrlTeamStandings = nrlTeamStandingsRepository.findTeamStandingsByTeamByes(teamByes);

        for (NrlTeamStandings standings : nrlTeamStandings) {

            NrlTeamStandingsDto dto = new NrlTeamStandingsDto();

            dto.setId(standings.getId());
            dto.setTeamName(standings.getTeamName());
            dto.setTeamPosition(standings.getTeamPosition());
            dto.setTeamNumberOfMatchesPlayed(standings.getTeamNumberOfMatchesPlayed());
            dto.setTeamPoints(standings.getTeamPoints());
            dto.setTeamWins(standings.getTeamWins());
            dto.setTeamLost(standings.getTeamLost());
            dto.setTeamTied(standings.getTeamTied());
            dto.setTeamDifference(standings.getTeamDifference());
            dto.setTeamByes(standings.getTeamByes());

            toReturn.add(dto);
        }

        return toReturn;
    }

    //getStandingsByWins
    public List<NrlTeamStandingsDto> getStandingsByTeamWins(long teamWins) {

        List<NrlTeamStandingsDto> toReturn = new ArrayList<>();

        List<NrlTeamStandings> nrlTeamStandings = nrlTeamStandingsRepository.findTeamStandingsByTeamWins(teamWins);

        for (NrlTeamStandings standings : nrlTeamStandings) {

            NrlTeamStandingsDto dto = new NrlTeamStandingsDto();

            dto.setId(standings.getId());
            dto.setTeamName(standings.getTeamName());
            dto.setTeamPosition(standings.getTeamPosition());
            dto.setTeamNumberOfMatchesPlayed(standings.getTeamNumberOfMatchesPlayed());
            dto.setTeamPoints(standings.getTeamPoints());
            dto.setTeamWins(standings.getTeamWins());
            dto.setTeamLost(standings.getTeamLost());
            dto.setTeamTied(standings.getTeamTied());
            dto.setTeamDifference(standings.getTeamDifference());
            dto.setTeamByes(standings.getTeamByes());

            toReturn.add(dto);
        }

        return toReturn;
    }

    //getStandingsByTeamLost
    public List<NrlTeamStandingsDto> getStandingsByTeamLost(long teamLost) {

        List<NrlTeamStandingsDto> toReturn = new ArrayList<>();

        List<NrlTeamStandings> nrlTeamStandings = nrlTeamStandingsRepository.findTeamStandingsByTeamLost(teamLost);

        for (NrlTeamStandings standings : nrlTeamStandings) {

            NrlTeamStandingsDto dto = new NrlTeamStandingsDto();

            dto.setId(standings.getId());
            dto.setTeamName(standings.getTeamName());
            dto.setTeamPosition(standings.getTeamPosition());
            dto.setTeamNumberOfMatchesPlayed(standings.getTeamNumberOfMatchesPlayed());
            dto.setTeamPoints(standings.getTeamPoints());
            dto.setTeamWins(standings.getTeamWins());
            dto.setTeamLost(standings.getTeamLost());
            dto.setTeamTied(standings.getTeamTied());
            dto.setTeamDifference(standings.getTeamDifference());
            dto.setTeamByes(standings.getTeamByes());

            toReturn.add(dto);
        }

        return toReturn;
    }

    //getStandingsByTeamTied
    public List<NrlTeamStandingsDto> getStandingsByTeamTied(long teamTied) {

        List<NrlTeamStandingsDto> toReturn = new ArrayList<>();

        List<NrlTeamStandings> nrlTeamStandings = nrlTeamStandingsRepository.findTeamStandingsByTeamTied(teamTied);

        for (NrlTeamStandings standings : nrlTeamStandings) {

            NrlTeamStandingsDto dto = new NrlTeamStandingsDto();

            dto.setId(standings.getId());
            dto.setTeamName(standings.getTeamName());
            dto.setTeamPosition(standings.getTeamPosition());
            dto.setTeamNumberOfMatchesPlayed(standings.getTeamNumberOfMatchesPlayed());
            dto.setTeamPoints(standings.getTeamPoints());
            dto.setTeamWins(standings.getTeamWins());
            dto.setTeamLost(standings.getTeamLost());
            dto.setTeamTied(standings.getTeamTied());
            dto.setTeamDifference(standings.getTeamDifference());
            dto.setTeamByes(standings.getTeamByes());

            toReturn.add(dto);
        }

        return toReturn;
    }

    //getStandingsByTeamPoints
    public List<NrlTeamStandingsDto> getStandingsByTeamPoints(long teamPoints) {

        List<NrlTeamStandingsDto> toReturn = new ArrayList<>();

        List<NrlTeamStandings> nrlTeamStandings = nrlTeamStandingsRepository.findTeamStandingsByTeamPoints(teamPoints);

        for (NrlTeamStandings standings : nrlTeamStandings) {

            NrlTeamStandingsDto dto = new NrlTeamStandingsDto();

            dto.setId(standings.getId());
            dto.setTeamName(standings.getTeamName());
            dto.setTeamPosition(standings.getTeamPosition());
            dto.setTeamNumberOfMatchesPlayed(standings.getTeamNumberOfMatchesPlayed());
            dto.setTeamPoints(standings.getTeamPoints());
            dto.setTeamWins(standings.getTeamWins());
            dto.setTeamLost(standings.getTeamLost());
            dto.setTeamTied(standings.getTeamTied());
            dto.setTeamDifference(standings.getTeamDifference());
            dto.setTeamByes(standings.getTeamByes());


            toReturn.add(dto);
        }

        return toReturn;
    }

    //getStandingsByNumberOfMatchesPlayed
    public List<NrlTeamStandingsDto> getStandingsByTeamNumberOfMatchesPlayed(long teamNumberOfMatchesPlayed) {

        List<NrlTeamStandingsDto> toReturn = new ArrayList<>();

        List<NrlTeamStandings> nrlTeamStandings = nrlTeamStandingsRepository.findTeamStandingsByTeamNumberOfMatchesPlayed(teamNumberOfMatchesPlayed);

        for (NrlTeamStandings standings : nrlTeamStandings) {

            NrlTeamStandingsDto dto = new NrlTeamStandingsDto();

            dto.setId(standings.getId());
            dto.setTeamName(standings.getTeamName());
            dto.setTeamPosition(standings.getTeamPosition());
            dto.setTeamNumberOfMatchesPlayed(standings.getTeamNumberOfMatchesPlayed());
            dto.setTeamPoints(standings.getTeamPoints());
            dto.setTeamWins(standings.getTeamWins());
            dto.setTeamLost(standings.getTeamLost());
            dto.setTeamTied(standings.getTeamTied());
            dto.setTeamDifference(standings.getTeamDifference());
            dto.setTeamByes(standings.getTeamByes());

            toReturn.add(dto);
        }

        return toReturn;
    }

    /*************************************Save************************************************/
    //saveStandings
    public ResponseEntity saveTeamStandings(NrlTeamStandingsDto dto) {

        NrlTeamStandings standingsToUpDate = new NrlTeamStandings();
        standingsToUpDate.setTeamName(dto.getTeamName());
        standingsToUpDate.setTeamPosition(dto.getTeamPosition());
        standingsToUpDate.setTeamNumberOfMatchesPlayed(dto.getTeamNumberOfMatchesPlayed());
        standingsToUpDate.setTeamPoints(dto.getTeamPoints());
        standingsToUpDate.setTeamWins(dto.getTeamWins());
        standingsToUpDate.setTeamLost(dto.getTeamLost());
        standingsToUpDate.setTeamTied(dto.getTeamTied());
        standingsToUpDate.setTeamDifference(dto.getTeamDifference());
        standingsToUpDate.setTeamByes(dto.getTeamByes());

        nrlTeamStandingsRepository.save(standingsToUpDate);

        return ResponseEntity.ok(dto);

    }
}
