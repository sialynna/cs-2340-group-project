package classes;

/**
 * Pace class
 * Pace determines how far the wagon and members move per day
 * and how fast the stamina of the members decreases.
 * 
 */
public class Pace 
{
	private int pacePerDay;

	/**
	 * constructor for pace
	 * 
	 */
	
	public Pace() {
		pacePerDay = 0;
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
