package classes;

import java.util.Random;

public class Event {
	private int event;
	private int chance;
	private int itemType;
	private int itemAmt;
	Random rn = new Random();

	/**
	 * Random event class
	 * 
	 */
	public Event()
	{
		
	}
	
	/**
	 * checks if there is an event this turn 
	 * @return event
	 */
	public boolean eventChance()
	{
		chance = rn.nextInt(3);
		if(chance ==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * generates event
	 * @return 0 = sick, 1 = dust storm, 2 = mox dies, 3 = found supplies, 4 = nothing happens
	 */
	public int generateEvent()
	{
		if(eventChance())
		{
			event=rn.nextInt(3);
			return event;
		}
		else
		{
			return 4;
			
		}
	}
	
	/**
	 * random member gets sick
	 */
	public String ranSick()
	{
		int ranMember;
		ranMember=rn.nextInt(GameEngine.getMembers().length);
		if(ranMember==0&&!GameEngine.getMembers()[0].isSick())
		{
			GameEngine.getMembers()[0].sick();
			return GameEngine.getMembers()[0].getName() + " caught the flu.";
		}
		else if(ranMember==1&&!GameEngine.getMembers()[1].isSick())
		{
			GameEngine.getMembers()[1].sick();
			return GameEngine.getMembers()[1].getName() + " caught the flu.";
		}
		else if (ranMember==2&&!GameEngine.getMembers()[2].isSick())
		{
			GameEngine.getMembers()[2].sick();
			return GameEngine.getMembers()[2].getName() + " caught the flu.";
		}
		else if(ranMember==3&&!GameEngine.getMembers()[3].isSick())
		{
			GameEngine.getMembers()[3].sick();
			return GameEngine.getMembers()[3].getName() + " caught the flu.";
		}
		else
		{
			return "A cold wind blew by today. But it doesn't seem anyone else got sick.";
		}
	}
	
	/**
	 * lose 3 turns.
	 */
	public String dustStorm()
	{
		GameEngine.setPace("Stopped");
		GameEngine.move();
		GameEngine.move();
		GameEngine.move();
		return "Nuclear Duststorm has appeared. It seems like it will be around for 3 days";
	}
	
	/**
	 * moxen dies.
	 */
	public String deadMox()
	{
		GameEngine.getSupplies().subItem(Item.MOXEN, 1);
		return "One of your moxen has spontaniously combusted";
	}
	
	/**
	 * find random item
	 */
	public String ranItem()
	{
		itemType=rn.nextInt(9);
		
		if(itemType==0) //mox
		{
			GameEngine.getSupplies().addItem(Item.MOXEN, 1);
			return "Hey you found a moxen, chilling around. You took it.";
		}
		else if(itemType==1) //supplies
		{
			itemAmt=rn.nextInt(10)+1;
			if(GameEngine.getSupplies().getWeightRemaining()>=(20*itemAmt))
			{
				GameEngine.getSupplies().addItem(Item.CLOTHES, itemAmt);
				return " Hey you found " +itemAmt+" bundle(s) of clothes!";
			}
			else
			{
				return "You noticed some extra supplies on the road, but you ignore it due to lack of room.";
			}
			
		}
		else if(itemType==2) //ammo
		{
			itemAmt=rn.nextInt(4)+1;
			if(GameEngine.getSupplies().getWeightRemaining()>=(50*itemAmt))
			{
				GameEngine.getSupplies().addItem(Item.AMMO, itemAmt);
				return " Hey you found " +itemAmt+" pack(s) of ammo!";
			}
			else
			{
				return "You noticed some extra supplies on the road, but you ignore it due to lack of room.";
			}
			
		}
		else if(itemType==3) //meds
		{
			itemAmt=rn.nextInt(10)+1;
			if(GameEngine.getSupplies().getWeightRemaining()>=(20*itemAmt))
			{
				GameEngine.getSupplies().addItem(Item.MEDS, itemAmt);
				return " Hey you found " +itemAmt+" pack(s) of medicine!";
			}
			else
			{
				return "You noticed some extra supplies on the road, but you ignore it due to lack of room.";
			}
			
		}
		else if(itemType==4) //axel
		{
			itemAmt=1;
			if(GameEngine.getSupplies().getWeightRemaining()>=(150*itemAmt))
			{
				GameEngine.getSupplies().addItem(Item.AXLES, itemAmt);
				return " Hey you found " +itemAmt+" axle!";
			}
			else
			{
				return "You noticed some extra supplies on the road, but you ignore it due to lack of room.";
			}
		}
		else if(itemType==5) //wheel
		{
			itemAmt=rn.nextInt(2)+1;
			if(GameEngine.getSupplies().getWeightRemaining()>=(100*itemAmt))
			{
				GameEngine.getSupplies().addItem(Item.WHEELS, itemAmt);
				return " Hey you found " +itemAmt+" wheel(s)!";
			}
			else
			{
				return "You noticed some extra supplies on the road, but you ignore it due to lack of room.";
			}
		}
		else if(itemType==6) //wheel
		{
			itemAmt=rn.nextInt(2)+1;
			if(GameEngine.getSupplies().getWeightRemaining()>=(100*itemAmt))
			{
				GameEngine.getSupplies().addItem(Item.WHEELS, itemAmt);
				return " Hey you found " +itemAmt+" wheel(s)!";
			}
			else
			{
				return "You noticed some extra supplies on the road, but you ignore it due to lack of room.";
			}
		}
		else if(itemType==7) //yoke
		{
			itemAmt=rn.nextInt(2)+1;
			if(GameEngine.getSupplies().getWeightRemaining()>=(80*itemAmt))
			{
				GameEngine.getSupplies().addItem(Item.YOKES, itemAmt);
				return " Hey you found " +itemAmt+" yoke(s)!";
			}
			else
			{
				return "You noticed some extra supplies on the road, but you ignore it due to lack of room.";
			}
		}
		else if(itemType==8) //rations
		{
			itemAmt=rn.nextInt(10)+1;
			if(GameEngine.getSupplies().getWeightRemaining()>=(20*itemAmt))
			{
				GameEngine.getSupplies().addItem(Item.RATIONS, itemAmt);
				return " Hey you found " +itemAmt+" box(es) of rations!";
			}
			else
			{
				return "You noticed some extra supplies on the road, but you ignore it due to lack of room.";
			}
		}
		else
		{
			return "You noticed some extra supplies on the road, but you ignore it due to lack of room.";
		}
	}
	
	
	
//	/**
//	 * removes a moxen from inventory. 
//	 * @param item
//	 * @param sup
//	 */
//	public void moxDies(Item item,Supplies sup){
//		sup.subItem(item.MOXEN, 1);
//		
//	}

}
