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
	private double[] landmarkDistances = {140, 290, 480, 600, 790, 940, 1140, 1290, 1400, 1500};
	
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
	
	public double getLandmarkDist(){
		return landmarkDistances[playerAtLandmark];
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
		if(playerLocation >= 130)
		{
			setLocation(140);
			playerAtLandmark = 1;
			return "Ft. Kearny";
		}
		else if(playerLocation >= 280)
		{
			setLocation(290);
			playerAtLandmark = 2;
			return "Ft. Laramie";
		}
		else if(playerLocation >= 470)
		{
			setLocation(480);
			playerAtLandmark = 3;
			return "Hudsonion River";
		}
		else if(playerLocation >= 590)
		{
			setLocation(600);
			playerAtLandmark = 4;
			return "Ft. Bridger";
		}
		else if(playerLocation >= 780)
		{
			setLocation(790);
			playerAtLandmark = 5;
			return "Ft. Hall";
		}
		else if(playerLocation >= 930)
		{
			setLocation(940);
			playerAtLandmark = 6;
			return "Alpine Stream";
		}
		else if(playerLocation >= 1130)
		{
			setLocation(1140);
			playerAtLandmark = 7;
			return "Ft. Boise";
		}
		else if(playerLocation>=1280)
		{
			setLocation(1290);
			playerAtLandmark = 8;
			return "Whitman's Mission";
		}
		else if(playerLocation >= 1390)
		{
			setLocation(1400);
			playerAtLandmark = 9;
			return "Ft. Vancouver";
		}
		else if(playerLocation >= 1500)
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
