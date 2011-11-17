package classes;

import java.io.Serializable;

/**
 * ration class
 * Rations determine how fast the health and stamina of the
 * members decrease or increase
 * 
 */
public class Rations implements Serializable 
{
	private int rationsPerDay;
	private enum rations{STARVATION,MEAGER,NORMAL,FILLING};
	
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
	public String getRations()
	{
		rations[] rationsEnum = rations.values();
		return rationsEnum[rationsPerDay].toString();
	}
	
	public int getRationsNum(){
		return rationsPerDay;
	}
	
	/**
	 * setter for ration
	 * @param val the value.
	 */
	public void setRations(int val)
	{
		this.rationsPerDay = val;
	}
	
}
