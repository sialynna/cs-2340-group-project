package classes;

public class Pace 
{
	private int pacePerDay;

	public Pace(int initialPace)
	{
		this.pacePerDay = initialPace;
	}
	
	public void setPace(int pacePerDay)
	{
		this.pacePerDay = pacePerDay;
	}
	public int getPace()
	{
		return pacePerDay;
	}
}
