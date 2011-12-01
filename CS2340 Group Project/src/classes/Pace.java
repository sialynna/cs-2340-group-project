package classes;

import java.io.Serializable;


/**
 * Pace class
 * Pace determines how far the wagon and members move per day
 * and how fast the stamina of the members decreases.
 * 
 */
public class Pace implements Serializable 
{
	private int pacePerDay;
	private enum Paces{STOPPED,EASY,NORMAL,GRUELING};

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
	public String getPace()
	{
		Paces[] paceEnum = Paces.values();
		return paceEnum[pacePerDay].toString();
	}
	
	public int getPaceNum(){
		return pacePerDay;
	}
}
