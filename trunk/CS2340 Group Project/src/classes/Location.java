	package classes;

import java.io.Serializable;

/**
 * 
 * Where the wagon is located. 
 *
 */
public class Location implements Serializable 
{
	private double playerLocation;
	private Map map;
	private Pace pace;
	private int playerAtLandmark;
	private double[] landmarkDistances = {0, 140, 290, 480, 600, 790, 940, 1140, 1290, 1400, 1500};
	
	/**
	 * Constructor.
	 * @param playerLocation the location
	 * @param map the map for reference
	 * @param pace the pace
	 */
	public Location(int playerLocation, Map map, Pace pace)
	{
		playerAtLandmark = 0;
		this.playerLocation = playerLocation;
		this.map = map;
		this.pace = pace;
	}
	
	/**
	 * updates player location based off pace.
	 * @return the updated location.
	 */
	public double updateLocation()
	{
		
		if(pace.getPaceNum() == 1)
		{
			playerLocation += 15;
		}
		else if(pace.getPaceNum() == 2)
		{
			playerLocation += 25;
		}
		else if(pace.getPaceNum() == 3)
		{
			playerLocation += 40;
		}
		
		setLandmark();
		
		return playerLocation;
			
	}	
	/**
	 * get the location
	 * @return the location
	 */
	public Double getLocation(){
		return playerLocation;
	}
	public int getLandmarkAt(){
		return playerAtLandmark;
	}
	
	public double getLandmarkDist(int offset){
		return landmarkDistances[playerAtLandmark + offset];
	}
	
	private void setLocation(int loc){
		playerLocation = loc;
	}

	private void setLandmark()
	{
		if(playerLocation >= 130 && playerAtLandmark == 0)
		{
			setLocation(140);
			playerAtLandmark = 1;
		}
		else if(playerLocation >= 280 && playerAtLandmark == 1)
		{
			setLocation(290);
			playerAtLandmark = 2;
		}
		else if(playerLocation >= 470 && playerAtLandmark == 2)
		{
			setLocation(480);
			playerAtLandmark = 3;
		}
		else if(playerLocation >= 590 && playerAtLandmark == 3)
		{
			setLocation(600);
			playerAtLandmark = 4;
		}
		else if(playerLocation >= 780 && playerAtLandmark == 4)
		{
			setLocation(790);
			playerAtLandmark = 5;
		}
		else if(playerLocation >= 930 && playerAtLandmark == 5)
		{
			setLocation(940);
			playerAtLandmark = 6;
		}
		else if(playerLocation >= 1130 && playerAtLandmark == 6)
		{
			setLocation(1140);
			playerAtLandmark = 7;
		}
		else if(playerLocation>=1280 && playerAtLandmark == 7)
		{
			setLocation(1290);
			playerAtLandmark = 8;
		}
		else if(playerLocation >= 1390 && playerAtLandmark == 8)
		{
			setLocation(1400);
			playerAtLandmark = 9;
		}
		else if(playerLocation >= 1500 && playerAtLandmark == 9)
		{
			setLocation(1500);
		}

	}
	
	/**
	 * gets the type for the landmark.
	 * @param the location name.
	 * @return the type 1) Fort 2) River 3) Oregon 4) scenery(no interaction) 
	 */
	public int landmarkType()
	{
		if(getLandmarkName().equalsIgnoreCase("Ft. Kearny")||getLandmarkName().equalsIgnoreCase("Ft. Laramie")||getLandmarkName().equalsIgnoreCase("Ft. Bridger")||getLandmarkName().equalsIgnoreCase("Ft. Hall")||getLandmarkName().equalsIgnoreCase("Ft. Boise")||getLandmarkName().equalsIgnoreCase("Whitman's Mission")|| getLandmarkName().equalsIgnoreCase("Ft. Vancouver"))
		{
			return 1;	
		}
		else if(getLandmarkName().equalsIgnoreCase("Hudsonion River")||getLandmarkName().equalsIgnoreCase("Alpine Stream"))
		{
			return 2;
		}
		else if(getLandmarkName().equalsIgnoreCase("Oregon"))
		{
			return 3;
		}
		else
		{
			return 4;
		}
	}
	
	/**
	 * get the name of the landmark
	 * @return the name.
	 */
	
	public String getLandmarkName(){
		if (playerLocation == 140)
		{
			return "Ft. Kearny";
		}
		else if(playerLocation == 290)
		{
			return "Ft. Laramie";
		}
		else if(playerLocation == 480)
		{
			return "Hudsonion River";
		}
		else if(playerLocation == 600)
		{
			return "Ft. Bridger";
		}
		else if(playerLocation == 790)
		{
			return "Ft. Hall";
		}
		else if(playerLocation == 940)
		{
			return "Alpine Stream";
		}
		else if(playerLocation == 1140)
		{
			return "Ft. Boise";
		}
		else if(playerLocation == 1290)
		{
			return "Whitman's Mission";
		}
		else if(playerLocation == 1400)
		{
			return "Ft. Vancouver";
		}
		else if(playerLocation >= 1500)
		{
			return "Oregon";
		}
		else
		{
			return "Nothing to see here";
		}
	}
}
