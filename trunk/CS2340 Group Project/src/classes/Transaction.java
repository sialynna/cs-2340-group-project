package classes;
import gui.TradeWindow;

/**
 * Does all the moving between Supplies, Store, and Transaction Window
 * 
 * @author JeffZ
 *
 */

public class Transaction 
{

	Store store;
	Supplies supplies;
	TradeWindow window;
	int totalWeight;
	int playerMoney;
	int[] playerAmts = new int[8];
	
	/**
	 * Initialize transaction
	 * @param store the store
	 * @param supplies the supplies
	 * @param wagon the wagon
	 */
	public Transaction (Store store, Supplies supplies, TradeWindow window)
	{
		this.store = store;
		this.supplies = supplies;
		this.window = window;
		updateWindow();
	}
	/**
	 * Updates the transaction window after a purchase
	 */
	private void updateWindow(){
		updateWindowStore();
		updateWindowPlayer();
	}
	
	private void updateWindowStore(){
		window.setStore(store.getPrices(), store.getQuantities());
	}
	
	private void updateWindowPlayer(){
		Item[] items = Item.values();
		for (int i=0; i < Item.values().length; i++){
			playerAmts[i] = items[i].getNum();
		}
		window.setPlayer(playerAmts, supplies.getMoney(), supplies.getTotalWeight());
	}
	/**
	 * Checks to see if there is enough money for transaction and enough weight remaining.
	 * @return true/false
	 */
	public boolean checkLegit()
	{
		if((supplies.getMoney() > window.getTotalAmt()) && supplies.getWeightRemaining() > window.getTotalWt())
		{
			return true;
		}
		return false;
	}
	/**
	 * Adds the purchased amount of items to player supplies
	 * @param item the item
	 * @param amt the amount
	 */
	public void addItems(Item item, int amt)
	{
		if(store.getQuantity(item) > amt)
		{
			System.out.println(window.getTotalAmt());
			supplies.addItem(item, amt);
			store.subItem(item, amt);
			updateWindow();
		}
		else
		{
			//panel pops up saying "Store doesn't have this much"
		}
	}

	/**
	 * Subtracts purchase cost from the players money
	 * @return updated store.
	 */
	public void subMoney()
	{
		supplies.subMoney(window.getTotalAmt());
		updateWindow();
	}
	
}
