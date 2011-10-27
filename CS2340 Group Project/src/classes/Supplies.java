/**
 * Supply class.
 * @author Jay Zuerndorfer
 */

package classes;
public class Supplies {
	
	private int money = 0;
	private final int MAX_WEIGHT = 3500; //total wagon capacity in pounds
	private int totalWeight;
	
	/**
	 * initializes Supplies.
	 */
	public Supplies(String profession){
		
		if (profession.equals("Banker")){
			this.money = 1600;
		}
		else if (profession.equals("Farmer")){
			this.money = 900;
		}
		else if (profession.equals("Carpenter")){
			this.money = 1000;
		}
	}
	
	/**
	 * Totals the weight of all current items. Should be called after any item update.
	 */
	private void calcWeight(){
		int total = 0;
		for(Item i: Item.values())
		{
			total += i.weight * i.getNum();
		}
		
		totalWeight = total;
	}
	
	public int getWeight(Item item){
		return item.weight;
	}	
	
	public int getTotalWeight(){
		return totalWeight;
	}
	
	/**
	 * Gets how much weight is available before reaching maximum. 
	 * @return remaining.
	 */
	public int getWeightRemaining()
	{
		return MAX_WEIGHT - totalWeight;
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
	/**
	 * subtracts money
	 * @param subtraction amount of money to subtract.
	 */
	public void subMoney(int subtraction) {
		money -= subtraction;
	}
	/**
	 * Gets how many of an item the player has
	 * @param item the item value
	 * @return number of item
	 */
	public int getItem(Item item){
		return item.getNum();
	}
	
	/**
	 * adds item value
	 * @param item the item
	 * @param addition the specific amount to add. 
	 */
	public void addItem(Item item, int addition){
		item.add(addition);
		calcWeight();
	}

	public void subItem(Item item, int subtraction){
		item.sub(subtraction);
		calcWeight();
	}
}
