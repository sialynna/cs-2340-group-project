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
	 * adds an item to the wagon.
	 */
	public void addItem(){
		
	}
	/**
	 * removes an item from the wagon.
	 */
	public void removeItem(){
		
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
	 * getter for weight limit
	 * @return
	 */
	public int getWeightLimit(){
		return MAX_WEIGHT;
	}
	
}
