/**
 * Supply class.
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
			this.money = 750;
		}
		else if (profession.equals("Carpenter")){
			this.money = 900;
		}
	}
	
	private void calcWeight(){
		int total = 0;
		for(Item i: Item.values())
		{
			total += i.weight;
		}
		
		totalWeight = total;
	}
	
	public int getWeight(Item item){
		return item.weight;
	}	

	/**
	 * gets the remaining weight. 
	 * @return remaining.
	 */
	public int getWeightRemaining()
	{
		return MAX_WEIGHT-totalWeight;
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
