package classes;

import junit.framework.TestCase;
import java.util.Random;

/** This class tests all of the different outcomes of the river crossing method (crossRiver()) **/


//Written by Tom Bellitire
public class TomTest extends TestCase {
	Random rn = new Random(5);
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

	// written by Jeff Zhang
	public void testRanSick()
	{
		String output="";
		GameEngine.setMembers(4);
		GameEngine.getMembers()[0]=new Member("John");
		GameEngine.getMembers()[1]=new Member("Joe");
		GameEngine.getMembers()[2]=new Member("Jeff");
		GameEngine.getMembers()[3]=new Member("Jill");
		Event event=new Event();
		int chance = rn.nextInt(3);
		if(chance==0)
		{
			output="John caught the flu.";
		}
		else if(chance==1)
		{
			output="Joe caught the flu.";
		}
		else if(chance==2)
		{
			output="Jeff caught the flu.";
		}
		else
		{
			output="Jill caught the flu.";
		}
		
		
		assertEquals(event.ranSick(),output);
		
		GameEngine.getMembers()[0].sick();
		
		assertEquals(event.ranSick(),"A cold wind blew by today. But it doesn't seem anyone else got sick.");
	}
	
	public void testDeadMox()
	{
		Event event = new Event();
		Item.MOXEN.setNum(1);
		GameEngine.setSupplies(new Supplies("Banker"));
		assertEquals(event.deadMox(),"One of your moxen has spontaniously combusted");
		Item.MOXEN.setNum(0);
		assertEquals(event.deadMox(),"You feel tired. We really should get a mox at the next store.");
	}
	
	public void testRanItem()
	{
		Event event = new Event();
		int type = rn.nextInt(9);
		GameEngine.setSupplies(new Supplies("Banker"));
		
		assertEquals(event.ranItem(true)," Hey! You found 1 axle!");
		GameEngine.getSupplies().setWeight(3500);
		assertEquals(event.ranItem(true),"You noticed some extra supplies on the road, but you ignore it due to lack of room.");

	}
	
}
