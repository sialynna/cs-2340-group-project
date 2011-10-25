/**
 * 
 */
package program;

/**
 * @author Mitch
 *
 */
public abstract class person {
	//Class Variables
	private String name;
	private int health, stamina;
	private boolean isSick, isDead, isLeader, hasClothes;
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getStamina() {
		return stamina;
	}
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}
	public boolean isSick() {
		return isSick;
	}
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public boolean isLeader() {
		return isLeader;
	}
	public void setLeader(boolean isLeader) {
		this.isLeader = isLeader;
	}
	public boolean isHasClothes() {
		return hasClothes;
	}
	public void setHasClothes(boolean hasClothes) {
		this.hasClothes = hasClothes;
	}
	
}
