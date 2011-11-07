package classes;

/**
 * map class that is populated with locations/ destinations.
 * @author JeffZ
 *
 */
public class Map 
{
	int distance;
	
	public Map()
	{
		distance=0;
	}
	
	
	/**
	 * returns the landmark we need.
	 */
	public void getLandmark()
	{
		if(isLocation(distance))
		{
			
		}
	}
	/**
	 * checks if wagon passed a location yet.
	 * @param distance current location
	 * @return true or false
	 */
	public boolean isLocation(int distance)
	{
		this.distance=distance;
		if((distance>=100&&distance<=140)||(distance>=250&&distance<=290)||(distance>=420&&distance<=480)||(distance>=560&&distance<=600)||(distance>=750&&distance<=790)||(distance>=900&&distance<=940)||(distance>=1100&&distance<=1140)||(distance>=1250&&distance<=1290)||(distance>=1500))
		{
			return true;
		}
		else 
			return false;
	}
	

}
