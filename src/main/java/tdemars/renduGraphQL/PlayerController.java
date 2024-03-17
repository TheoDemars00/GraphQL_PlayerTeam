package tdemars.renduGraphQL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerDao playerDao;
	
	public PlayerController() {
		
	}
	
	@QueryMapping
	public List<Player> getPlayers(){
		return this.playerDao.getAllPlayers();
	}
	
	@MutationMapping
	public Player writePlayer(@Argument String id, @Argument String first_name, @Argument String last_name, @Argument String date_of_birth, @Argument String height) {
		
		Player player = new Player();
		player.setId(id);
		player.setFirst_name(first_name);
		player.setLast_name(last_name);
		player.setDate_of_birth(date_of_birth);
		player.setHeight(height);
		
		return playerDao.addPlayer(player);
	}
	
	
	@MutationMapping
	public Player deletePlayer(@Argument String id) {
		return playerDao.deletePlayerId(id);
	}
	
	@MutationMapping
	public Player updatePlayer(@Argument String id, @Argument String first_name, @Argument String last_name, @Argument String date_of_birth, @Argument String height) {
		
		Player updatedPlayer = new Player();
		updatedPlayer.setId(id);
		updatedPlayer.setFirst_name(first_name);
		updatedPlayer.setLast_name(last_name);
		updatedPlayer.setDate_of_birth(date_of_birth);
		updatedPlayer.setHeight(height);
		
		return playerDao.updatePlayerId(id,updatedPlayer);
	}

}
