package tdemars.renduGraphQL;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeamDao {
	private List<Team> teams;

    public TeamDao(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getAllTeams() {
    	
    	return this.teams.stream().collect(Collectors.toList());
    }

	public Team addTeam(Team team) {
		
		this.teams.add(team);
		
		return team;
	}
	
	 public Team deleteTeamId(String id) {
	        Optional<Team> teamOptional = teams.stream().filter(team -> team.getId().equals(id)).findFirst();
	        if (teamOptional.isPresent()) {
	        	Team deletedTeam = teamOptional.get();
	            teams.remove(deletedTeam);
	            return deletedTeam;
	        }
	        return null; //No team found
	    }
	 
	 public Team updateTeamId(String id, Team updatedTeam) {
	        for (int i = 0; i < teams.size(); i++) {
	            Team team = teams.get(i);
	            if (team.getId().equals(id)) {
	                teams.set(i, updatedTeam);
	                return team;
	            }
	        }
	        return null; //No team found
	    }
	

}
