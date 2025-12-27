package com.game.main;


    import com.game.player.Player;
    import com.game.unit.Soldier;

public class GameLauncher {
	 

		    public static void main(String[] args) {

		        Player player = new Player("Player 1");
		        Soldier soldier = new Soldier();

		        player.showResources();
		        soldier.draw();
		    
		}

}
