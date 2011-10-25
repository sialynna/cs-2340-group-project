/**
 * Supply class.
 */

package classes;
public class Supplies {
	
	private int[] items;
	private int money = 0;
	private int[] prices = {150, 50, 80, 200, 120, 20, 50, 10, 0};

	public int getWeight(int index){
		return weights[index];
	}	
	
	public int getPrice(int index){
		return prices[index];
	}
	
	public int[] getPrices() {
		return prices;
	}

	public void setPrices(int[] prices) {
		this.prices = prices;
	}

	public int[] getWeights() {
		return weights;
	}

	public void setWeights(int[] weights) {
		this.weights = weights;
	}

	private int[] weights = {0, 20, 50, 20, 100, 150, 80, 20, 20};
	
	/**
	 * initializes Supplies.
	 */
	public Supplies(){
		items = new int[Item.values().length];
		for(int i=0; i<items.length; i++)
		{
			items[i] = 0;
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
		return items[item.ordinal()];
	}
	/**
	 * setter for item
	 * @param item the item slot
	 * @param amt how much.
	 */
	public void setItem(Item item, int amt){
		items[item.ordinal()] = amt;
	}
	/**
	 * adds item value
	 * @param item the item
	 * @param addition the specific amount to add. 
	 */
	public void addItem(Item item, int addition){
		items[item.ordinal()] += addition;
	}

	public void subItem(Item item, int subtraction){
		items[item.ordinal()] -= subtraction;
	}
}
