/**
 * Supply class.
 */

package classes;
public class Supplies {
	
	private int[] itemAmts;
	private int money = 0;
	private final int MAX_WEIGHT = 3500; //total wagon capacity in pounds
	private int weight;
	private int[] weights = {0, 20, 50, 20, 100, 150, 80, 20, 20};
	
	public int getWeight(Item item){
		return weights[item.ordinal()];
	}	

	public int[] getWeights() {
		return weights;
	}

	public void setWeights(int[] weights) {
		this.weights = weights;
	}
	/**
	 * gets the remaining weight. 
	 * @return remaining.
	 */
	public int getWeightRemaining()
	{
		return MAX_WEIGHT-weight;
	}
	
	public void addWeight(int addition)
	{
		weight+=addition;
	}


	
	/**
	 * initializes Supplies.
	 */
	public Supplies(String profession){
		itemAmts = new int[Item.values().length];
		for(int i=0; i<itemAmts.length; i++)
		{
			itemAmts[i] = 0;
		}
		if (profession.equals("Banker")){
			this.money = 1600;
		}
		else if (profession.equals("Farmer")){
			this.money = 750;
		}
		else if (profession.equals("Carpenter")){
			this.money = 900;
		}
	}
	
/**
 * getter for money
 * @return money
 */
	public int getMoney() {
		return money;
	}
	/**
	 * setter for money
	 * @param money the money value.
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	/**
	 * adds money
	 * @param addition amount of money to add.
	 */
	public void addMoney(int addition) {
		money += addition;
	}
	
	public void subMoney(int subtraction) {
		money -= subtraction;
	}
	/**
	 * getter for specific item
	 * @param item the item value
	 * @return the item
	 */
	public int getItem(Item item){
		return itemAmts[item.ordinal()];
	}
	/**
	 * setter for item
	 * @param item the item slot
	 * @param amt how much.
	 */
	public void setItem(Item item, int amt){
		itemAmts[item.ordinal()] = amt;
	}
	/**
	 * adds item value
	 * @param item the item
	 * @param addition the specific amount to add. 
	 */
	public void addItem(Item item, int addition){
		itemAmts[item.ordinal()] += addition;
	}

	public void subItem(Item item, int subtraction){
		itemAmts[item.ordinal()] -= subtraction;
	}
}
