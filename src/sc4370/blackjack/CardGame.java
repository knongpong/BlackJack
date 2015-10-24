package sc4370.blackjack;

import java.util.ArrayList;

/**
 * 
 * @Author Chirag Kakad.
 *
 */

public abstract class CardGame {
	private Dealer dealer;
	private ArrayList<Player> players;

	publicCardGame(Dealer d){
		dealer = d;
		players = new ArrayList<Player>();
	}

	public boolean updateBets(){
		for (int i = 0; i<players.size(); i++){
			boolean tmp = players.get(i).deductAssets(players.get(i).getBet());
			if (!tmp){
				for (int j = 0; j<i; j++)
					players.get(j).addAssets(players.get(j).getBet());
				return false;
			}
		}
		return true;
	}

	public boolean addPlayer(Player p){
		for (int i = 0; i<players.size(); i++){
			if (players.get(i).getName().equalsIgnoreCase(p.getName())){
				return false;
			}
		}
		players.add(p);
		return true;
	}

	public void removePlayer(int index){
		players.remove(index);
	}

	//mark: abstract functions.
	public abstract boolean startCardGame();

	public abstract void resetCardGame();
}
