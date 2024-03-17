package tdemars.renduGraphQL;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayerDao {
	
	private List<Player> players;
	
	public PlayerDao(List<Player> players) {
		this.players = players;
	}
	
	public List<Player> getAllPlayers(){
		return this.players.stream().collect(Collectors.toList());
	}
	
	public Player addPlayer(Player player) {
		this.players.add(player);
		
		return player;
	}
	
	 public Player deletePlayerId(String id) {
	        Optional<Player> playerOptional = players.stream().filter(player -> player.getId().equals(id)).findFirst();
	        if (playerOptional.isPresent()) {
	        	Player deletedPlayer = playerOptional.get();
	            players.remove(deletedPlayer);
	            return deletedPlayer;
	        }
	        return null; //No player found
	    }
	 
	 public Player updatePlayerId(String id, Player updatedPlayer) {
	        for (int i = 0; i < players.size(); i++) {
	            Player player = players.get(i);
	            if (player.getId().equals(id)) {
	                players.set(i, updatedPlayer);
	                return player;
	            }
	        }
	        return null; //No player found
	    }

}
