package classes;

public class Store {
	
	private int[] prices, quantity;
	
	public Store(int[] prices, int[] quantity){
		this.prices = prices;
		this.quantity = quantity;
	}

	public int[] getPrices() {
		return prices;
	}
	
	public int[] getQuantities(){
		return quantity;
	}

	public int getQuantity(Item item) {
		return quantity[item.ordinal()];
	}
	
	public int getPrice(Item item){
		return prices[item.ordinal()];
	}
	
	public void subItem(Item item, int amount){
		quantity[item.ordinal()] -= amount;
	}
}
