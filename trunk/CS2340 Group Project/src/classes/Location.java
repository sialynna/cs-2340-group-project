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
	
	private void setLocation(int loc){
		playerLocation = loc;
	}
	
	/**
	 * get the name of the landmark
	 * @return the name.
	 */
	public String getLandmark()
	{
		if(playerLocation>=100&&playerLocation<=140)
		{
			setLocation(140);
			return "Ft. Kearny";
		}
		else if(playerLocation>=250&&playerLocation<=290)
		{
			setLocation(290);
			return "Ft. Laramie";
		}
		else if(playerLocation>=420&&playerLocation<=480)
		{
			setLocation(480);
			return "Hudsonion River";
		}
		else if(playerLocation>=560&&playerLocation<=600)
		{
			setLocation(600);
			return "Ft. Bridger";
		}
		else if(playerLocation>=750&&playerLocation<=790)
		{
			setLocation(790);
			return "Ft. Hall";
		}
		else if(playerLocation>=900&&playerLocation<=940)
		{
			setLocation(940);
			return "Alpine Stream";
		}
		else if(playerLocation>=1100&&playerLocation<=1140)
		{
			setLocation(1140);
			return "Ft. Boise";
		}
		else if(playerLocation>=1250&&playerLocation<=1290)
		{
			setLocation(1290);
			return "Whitman's Mission";
		}
		else if(playerLocation>=1440&&playerLocation<=1400)
		{
			setLocation(1400);
			return "Ft. Vancouver";
		}
		else if(playerLocation>=1500)
		{
			setLocation(1500);
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
	 * @return the type 1) Fort 2) River 3) Oregon 4) scenery(no interaction) 
	 */
	public int landmarkType()
	{
		if(getLandmark().equalsIgnoreCase("Ft. Kearny")||getLandmark().equalsIgnoreCase("Ft. Laramie")||getLandmark().equalsIgnoreCase("Ft. Bridger")||getLandmark().equalsIgnoreCase("Ft. Hall")||getLandmark().equalsIgnoreCase("Ft. Boise")||getLandmark().equalsIgnoreCase("Whitman's Mission")|| getLandmark().equalsIgnoreCase("Ft. Vancouver"))
		{
			return 1;	
		}
		else if(getLandmark().equalsIgnoreCase("Hudsonion River")||getLandmark().equalsIgnoreCase("Alpine Stream"))
		{
			return 2;
		}
		else if(getLandmark().equalsIgnoreCase("Oregon"))
		{
			return 3;
		}
		else
		{
			return 4;
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
