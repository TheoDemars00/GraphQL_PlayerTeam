package tdemars.renduGraphQL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {
	
	 @Bean
	   public PlayerDao playerDao() {
	        List<Player> players = new ArrayList<>();
	        for (int playerId = 0; playerId < 5; ++playerId) {
	            Player player = new Player();
	            player.setId("" + playerId);
	            player.setFirst_name("First Name " + playerId);
	            player.setLast_name("Last Name " + playerId);
	            player.setDate_of_birth("Birth date of player " + playerId);
	            player.setHeight("Height " + playerId);
	            players.add(player);
	        }
	        return new PlayerDao(players);
	    }
	
	
	 @Bean
	   public TeamDao teamDao() {
	        List<Team> teams = new ArrayList<>();
	        for (int teamId = 0; teamId < 5; ++teamId) {
	            Team team = new Team();
	            team.setId("" + teamId);
	            team.setTeamName("Team Name " + teamId);
	            team.setCity("City " + teamId);
	            teams.add(team);
	        }
	        return new TeamDao(teams);
	    }

}
