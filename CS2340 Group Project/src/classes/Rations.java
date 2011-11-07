package classes;

/**
 * ration class
 * Rations determine how fast the health and stamina of the
 * members decrease or increase
 * 
 */
public class Rations 
{
	private int rationsPerDay;
	
	/**
	 * Constructor, initially set by GameEngine
	 * 
	 */
	
	public Rations() {
		rationsPerDay = 0;
	}

	/**
	 * getter for ration
	 * @return the ration value
	 */
	public int getRations()
	{
		return rationsPerDay;
	}
	
	/**
	 * setter for ration
	 * @param val the value.
	 */
	public void setRations(int val)
	{
		this.rationsPerDay=val;
	}
	
}
