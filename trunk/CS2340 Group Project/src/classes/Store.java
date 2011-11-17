package classes;

import java.io.Serializable;

/**
 * the Store class
 * Stores are created when a player hits certain milestones
 * within the game, and an initial store at game start
 * 
 * @author Christopher
 *
 */
public class Store implements Serializable{
	
	private int[] prices, quantity;
	
	/**
	 * Constructor, creates the store with set prices and quantities
	 * @param prices the prices of each item
	 * @param quantity the store's quantity of each item
	 */
	public Store(int[] prices, int[] quantity){
		this.prices = prices;
		this.quantity = quantity;
	}

	/**
	 * Getter for the prices array
	 * @return int[] prices
	 */
	public int[] getPrices() {
		return prices;
	}
	
	/**
	 * Getter for the item quantities array
	 * @return int[] quantities
	 */
	public int[] getQuantities(){
		return quantity;
	}

	/**
	 * Getter for the quantity of a certain item
	 * @param item the item in question
	 * @return int the quantity of the item
	 */
	public int getQuantity(Item item) {
		return quantity[item.ordinal()];
	}
	
	/**
	 * Getter for the price of a certain item
	 * @param item the item in question
	 * @return int the price of the item
	 */
	public int getPrice(Item item){
		return prices[item.ordinal()];
	}
	
	/**
	 * Subtracts a purchased item from store quantity
	 * @param item the item purchased
	 * @param amount the amount subtracted
	 */
	public void subItem(Item item, int amount){
		quantity[item.ordinal()] -= amount;
	}
	
}
