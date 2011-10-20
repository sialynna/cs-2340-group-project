/**
 * Supply class.
 */

package classes;
public class Supplies {
	public enum Item{
		MOXEN, CLOTHES, AMMO, MEDS, AXLES, WHEELS, YOKES, RATIONS, ITEMS
	}
	
	private int[] items;
	private int money = 0;
	
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
	/**
	 * Adds up all of the items contained inside of the wagon.
	 * Used in wagon class to check if MAX_WEIGHT has been reached.
	 * @return weight of all the items in the wagon (doesn't include moxen)
	 */
	public void checkWagonWeight(){
		 Wagon.setWagonWeight((items[1] * 2) + (items[2] * 1) + (items[3] * 1) + (items[4] * 20)+(items[5] * 5) +(items[6] *4)+(items[7]*1));
	}
}
