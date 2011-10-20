package classes;
/**
 * NOT FINISHED
 * @author tom
 *
 */
public class Wagon {
	private static final int MAX_WEIGHT = 300; //total wagon capacity in pounds
	private static int weight;
	
	public Wagon(){ 
		weight = 0;
	}
	
	public static void setWagonWeight(int weight){
		Wagon.weight = weight;
		if(checkWeight() == false){
			
			
		}
	}
	
	public static boolean checkWeight(){
		return weight <= MAX_WEIGHT;
	}
	
}
