package classes;

import java.util.Random;

/**
 * Handle river crossing events
 *
 */
public class RiverCrossing {

	private final int[] RIVER_DEPTH = {20, 20};
	
	
	private int depth;
	
	/**
	 * Constructor for RiverCrossing.
	 * @param riverID Integer that determines which river is being crossed.
	 */
	public RiverCrossing(int riverID){
		
		depth = RIVER_DEPTH[riverID];
	}
	
	public int getDepth(){
		return depth;
	}
	
	/**
	 * Takes in the players choice to cross the river and determines the results
	 * @param choice Integer for the player's decision. 0 for fording the river, 1 for floating across, 2 for paying the ferry
	 * @return An array with the results. 1st element is which item was lost (0 if none), 2nd is how much was lost, 3rd is how much money was used
	 */
	public int[] crossRiver(int choice){
		Random r = new Random();
		int[] lost = new int[3];
		//lost[0] is which item, lost[1] is how much, lost[2] is money spent
		int badProb;
		
		switch(choice){
		case 0: //try to ford the river
			badProb = depth + r.nextInt(30);
			lost[2] = 0; //not spending money
			break;
			
		case 1: //caulk the wagon and float across
			badProb = depth + r.nextInt(20);
			lost[2] = 0; //not spending money
			break;
			
		case 2: //pay for a ferry
			badProb = 0;
			lost[2] = 100;
			break;
			
		case 3: //Used to test code, guaranteed bad outcome
			badProb = 50;
			lost[2] = 0;
			break;
			
		default: //Use to test code, guaranteed good outcome
			badProb = 0;
			lost[2] = 0;
		}
		
		if(badProb > 30){
			lost[0] = r.nextInt(7)+1; //random item (not MOXEN)
			lost[1] = r.nextInt(10)+1; //random amount, 1-10
		}
		else{
			lost[0] = 0;
			lost[1] = 0;
		}
		
		return lost;
	}
}
