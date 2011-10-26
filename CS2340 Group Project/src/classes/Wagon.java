package classes;
/**
 * Represents a wagon that is responsible for holding items.
 *
 */
public class Wagon {
	private final int MAX_WEIGHT = 3500; //total wagon capacity in pounds
	private int weight;
	private Supplies supplies;
	
	/**
	 * Initializes weight
	 */
	public Wagon(){ 
		weight = 0;
	}
	/**
	 * weight setter
	 * @param weight
	 */
	public void setWeight(int weight){
		this.weight = weight;
	}
	/**
	 * gets weight
	 * @return
	 */
	public int getWeight(){
		return weight;
	}
	
	/**
	 * gets the remaining weight. 
	 * @return remaining.
	 */
	public int getWeightRemaining()
	{
		return MAX_WEIGHT-weight;
	}
	
	/**
	 * adds weight
	 * @param addition the amount
	 */
	public void addWeight(int addition)
	{
		weight+=addition;
	}
	/**
	 * getter for weight limit
	 * @return
	 */
	public int getWeightLimit(){
		return MAX_WEIGHT;
	}
	
}
