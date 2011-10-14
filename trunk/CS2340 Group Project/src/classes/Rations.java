package classes;

/**
 * ration class
 * 
 *
 */
public class Rations 
{
	private int rationsPerDay;
	
	/**
	 * takes in val.
	 * @param val the value
	 */
	public Rations(int val)
	{
		this.rationsPerDay=val;
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
