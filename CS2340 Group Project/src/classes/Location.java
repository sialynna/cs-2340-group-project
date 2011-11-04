package classes;

/**
 * 
 * Where the wagon is located. 
 *
 */
public class Location 
{
	private int playerLocation;
	private Map map;
	private Pace pace;
	
	/**
	 * Constructor.
	 * @param playerLocation the location
	 * @param map the map for reference
	 * @param pace the pace
	 */
	public Location(int playerLocation, Map map,Pace pace)
	{
		this.playerLocation=playerLocation;
		this.map=map;
		this.pace=pace;
	}
	
	/**
	 * updates player location based off pace.
	 * @return the updated location.
	 */
	public int updateLocation()
	{
		if(pace.getPace()==1)
		{
			playerLocation+=15;
		}
		else if(pace.getPace()==2)
		{
			playerLocation+=25;
		}
		else if(pace.getPace()==3)
		{
			playerLocation+=40;
		}
		return playerLocation;
			
	}
	
	
}
