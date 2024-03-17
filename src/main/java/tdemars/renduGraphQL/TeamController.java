package tdemars.renduGraphQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TeamController {
	
	@Autowired
	private TeamDao teamDao; 
	
	public TeamController(){
		
	}
	
	 @QueryMapping
	 public List<Team> getTeams() {
	        return this.teamDao.getAllTeams();
	    }
	    
	 @MutationMapping
	 public Team writeTeam(@Argument String id, @Argument String team_name, @Argument String city) {
	    	
	    Team team = new Team();
	    team.setId(id);
	    team.setTeamName(team_name);
	    team.setCity(city);
	    	
	    return teamDao.addTeam(team);
	 	}
	 
	 @MutationMapping
	 public Team deleteTeam(@Argument String id) {
		 return teamDao.deleteTeamId(id);
	 }
	 
	 @MutationMapping
	 public Team updateTeam(@Argument String id, @Argument String team_name, @Argument String city) {
	    	
	    Team updatedTeam = new Team();
	    updatedTeam.setId(id);
	    updatedTeam.setTeamName(team_name);
	    updatedTeam.setCity(city);
	    	
	    return teamDao.updateTeamId(id,updatedTeam);
	 	}

}
