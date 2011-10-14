package classes;

/**
 * Pace class
 * 
 *
 */
public class Pace 
{
	private int pacePerDay;

	/**
	 * constructor for pace
	 * @param initialPace the starting value.
	 */
	public Pace(int initialPace)
	{
		this.pacePerDay = initialPace;
	}
	
	/**
	 * setter for pace
	 * @param pacePerDay the amount of pace.
	 */
	public void setPace(int pacePerDay)
	{
		this.pacePerDay = pacePerDay;
	}
	/**
	 * getter for pace.
	 * @return the pace.
	 */
	public int getPace()
	{
		return pacePerDay;
	}
}
