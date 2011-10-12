package classes;

public class Supplies {
	public enum Item{
		RATIONS, AMMO, CLOTHES, WHEELS
	}
	
	private int[] items;
	private int money = 0;
	
	public Supplies(){
		items = new int[Item.values().length];
		for(int i=0; i<items.length; i++)
		{
			items[i] = 0;
		}
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void addMoney(int addition) {
		money += addition;
	}
	
	public int getItem(Item item){
		return items[item.ordinal()];
	}
	public void setItem(Item item, int amt){
		items[item.ordinal()] = amt;
	}
	public void addItem(Item item, int addition){
		items[item.ordinal()] += addition;
	}
}
