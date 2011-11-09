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
	public Location(int playerLocation, Map map, Pace pace)
	{
		this.playerLocation = playerLocation;
		this.map = map;
		this.pace = pace;
	}
	
	/**
	 * updates player location based off pace.
	 * @return the updated location.
	 */
	public int updateLocation()
	{
		if(pace.getPaceNum()==1)
		{
			playerLocation+=15;
		}
		else if(pace.getPaceNum()==2)
		{
			playerLocation+=25;
		}
		else if(pace.getPaceNum()==3)
		{
			playerLocation+=40;
		}
		return playerLocation;
			
	}	
	/**
	 * get the location
	 * @return the location
	 */
	public int getLocation(){
		return playerLocation;
	}
	
	/**
	 * get the name of the landmark
	 * @return the name.
	 */
	public String getLandmark()
	{
		if(playerLocation>=100&&playerLocation<=140)
		{
			return "Sandy Hills";
		}
		else if(playerLocation>=250&&playerLocation<=290)
		{
			return "Jetson Caverns";
		}
		else if(playerLocation>=420&&playerLocation<=480)
		{
			return "Hudsonion River";
		}
		else if(playerLocation>=560&&playerLocation<=600)
		{
			return "Sunnyville";
		}
		
		else if(playerLocation>=750&&playerLocation<=790)
		{
			return "Johnson Creek";
		}
		else if(playerLocation>=900&&playerLocation<=940)
		{
			return "Alpine Stream";
		}
		else if(playerLocation>=1100&&playerLocation<=1140)
		{
			return "Logsville";
		}
		else if(playerLocation>=1250&&playerLocation<=1290)
		{
			return "Satan's Alley";
		}
		else if(playerLocation>=1500)
		{
			return "Oregon";
		}
		else
		{
			return "Nothing to see here";
		}
	}
	
	/**
	 * gets the type for the landmark.
	 * @param the location name.
	 * @return the type 1)shop 2)river 3) scenery(no interaction)
	 */
	public int landmarkType(String string)
	{
		if(string.equalsIgnoreCase("Sandy Hills")||string.equalsIgnoreCase("Sunnyville")||string.equalsIgnoreCase("Johnson Creek")||string.equalsIgnoreCase("Logsville")||string.equalsIgnoreCase("Satan's Alley"))
		{
			return 1;
		}
		else if(string.equalsIgnoreCase("Hudsonion River")||string.equalsIgnoreCase("Alpine Stream"))
		{
			return 2;
		}
		else
		{
			return 3;
		}
	}
//	/**
//	 * checks if wagon passed a location yet.
//	 * @param playerLocation current location
//	 * @return true or false
//	 */
//	public boolean isLocation(int playerLocation)
//	{
//		this.playerLocation=playerLocation;
//		if((playerLocation>=100&&playerLocation<=140)||(playerLocation>=250&&playerLocation<=290)||(playerLocation>=420&&playerLocation<=480)||(playerLocation>=560&&playerLocation<=600)||(playerLocation>=750&&playerLocation<=790)||(playerLocation>=900&&playerLocation<=940)||(playerLocation>=1100&&playerLocation<=1140)||(playerLocation>=1250&&playerLocation<=1290)||(playerLocation>=1500))
//		{
//			return true;
//		}
//		else 
//			return false;
//	}
	
}
