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
	public void testRanSick()
	{
		GameEngine.setMembers(4);
		GameEngine.getMembers()[0].setName("John");
		GameEngine.getMembers()[1].setName("Joe");
		GameEngine.getMembers()[2].setName("Jeff");
		GameEngine.getMembers()[3].setName("Jill");
		Event event=new Event();
		int chance = rn.nextInt(3);
		if(chance==0)
		{
			GameEngine.
			assertEquals(event.ranSick());
		}
		else
		{
			assertEquals(Event.eventChance(),false);
		}
	}
}
