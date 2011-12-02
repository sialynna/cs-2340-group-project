package classes;

import junit.framework.TestCase;

/** This class tests all of the different outcomes of the river crossing method (crossRiver()) **/

public class TomTest extends TestCase {
	RiverCrossing river = new RiverCrossing(1);
	RiverCrossing otherRiver = new RiverCrossing(1);
	public void testRiverCrossing(){
		int pass = 0;
		
		//tests case statement
		assertEquals("Case 0 fails", 0 , river.crossRiver(0)[2]);
		assertEquals("Case 1 fails", 0 , river.crossRiver(1)[2]);
		assertEquals("Case 2 fails", 100 , river.crossRiver(2)[2]);
		assertEquals("Case 3 fails", 0 , river.crossRiver(3)[2]);
		assertEquals("Default case fails", 0 , river.crossRiver(17)[2]);
		
		//tests conditional(if part) 
		int x = river.crossRiver(0)[0];
		
		//checks random number generated for lost[0]
		if(x > 0){
			pass = 1;
		}
		
		assertEquals("Bad Prob(if) fails", 1 , pass);
		
		
		//tests conditional(else part) 
		x = otherRiver.crossRiver(2)[0] - 100;
		
		//checks random number generated for lost[0]
		if(x > 0){
			pass = 1;
		}
		
		else{
			pass = 0;
		}
		
		assertEquals("Bad Prob(else) fails", 0 , pass);
		
	}
	
	
}
