package classes;

/**
 * does all the moving between wagon and store. 
 * @author JeffZ
 *
 */

public class Transaction 
{

	Wagon wagon;
	Supplies supplies;
	public Transaction (Wagon wagon, Supplies supplies)
	{
		this.wagon=wagon;
		this.supplies=supplies;
	}
	
	public boolean checkSupplies()
	{
		if(supplies!=null)
		{
			return true;
		}
		return false;
	}
	public boolean checkWeight()
	{
		if(supplies.)
	}
	
	public void transact(Item bob, int amt)
	{
		wagon.subItem(bob,amt);
		wagon.addItem(bob,amt);
	}
	
}
