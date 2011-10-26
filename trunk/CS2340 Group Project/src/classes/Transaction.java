package classes;

/**
 * does all the moving between wagon and store. 
 * @author JeffZ
 *
 */

public class Transaction 
{

	Store store;
	Supplies supplies;
	Wagon wagon;
	int totalWeight;
	int totalCost;
	
	/**
	 * initializes it.
	 * @param store the store
	 * @param supplies the supplies
	 * @param wagon the wagon
	 */
	public Transaction (Store store, Supplies supplies,Wagon wagon)
	{
		this.store=store;
		this.supplies=supplies;
		totalWeight=0;
		totalCost=0;
	}
	
	/**
	 * checks to see if there is enough money for transaction and enough weight.
	 * @return true/false
	 */
	public boolean checkLegit()
	{
		if((supplies.getMoney()>totalCost)&&wagon.getWeightRemaining()>totalWeight)
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
	public void addItem(Item item, int amt)
	{
		if(store.getAmount(item)>amt)
		{
			supplies.addItem(item,amt);
			store.subItem(item,amt);
			totalWeight += supplies.getWeight(item)*amt;
			totalCost += supplies.getPrice(item)*amt;
		}
		else
		{
			//panel pops up saying "Store doesn't have this much"
		}
	}
	
	
	/**
	 * update the supplies. For usage if checkLegit works out!
	 * @return updated supplies
	 */
	public Supplies updateSupplies()
	{
		supplies.subMoney(totalCost);
		return supplies;
	}
	/**
	 * updates the wagon. Use if checkLEgit works!
	 * @return updated wagon.
	 */
	public Wagon updateWagon()
	{
		wagon.addWeight(totalWeight);
		return wagon;
	}
	/**
	 * updates the store. Use if checkLEgit works!
	 * @return updated store.
	 */
	public Store updateStore()
	{
		return store;
	}
	
	/**
	 * getter for total cost.
	 * @return the total cost.
	 */
	public int getTotalCost()
	{
		return totalCost;
	}
	
	/**
	 * getter for total weight.
	 * @return the total weight.
	 */
	public int getTotalWeight()
	{
		return totalWeight;
	}
	
}
