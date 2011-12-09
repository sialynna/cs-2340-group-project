package classes;
import java.util.Random;

import junit.framework.TestCase;

/**
 * 
 * @author JeffZhang
 *
 */
public class EventTest extends TestCase
{
	Random rn = new Random(5);
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
