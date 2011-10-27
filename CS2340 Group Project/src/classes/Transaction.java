package classes;
import gui.TradeWindow;

/**
 * Does all the moving between Supplies and Store. 
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
	 * checks to see if there is enough money for transaction and enough weight.
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
	 * adds item to the internal list.
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
	 * updates the store. Use if checkLegit works!
	 * @return updated store.
	 */
	public void subMoney()
	{
		supplies.subMoney(window.getTotalAmt());
		updateWindow();
	}
	
}
