package classes;

/**
 * Enumeration for game items: Name(weight, player quantity)
 * 
 * @author Christopher
 *
 */
public enum Item {
	MOXEN(0,0),
	CLOTHES(20,0),
	AMMO(50,0),
	MEDS(20,0),
	AXLES(150,0),
	WHEELS(100,0),
	YOKES(80,0),
	RATIONS(20,0);
	
	public final int weight;
	private int num;
	
	Item(int weight, int initNum){
		this.weight = weight;
		this.num = initNum;
	}
	
	public int getNum(){
		return num;
	}
	
	public void add(int num){
		this.num += num;
	}
	
	public void sub(int num){
		this.num -= num;
	}
}