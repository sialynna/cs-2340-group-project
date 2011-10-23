package classes;

/**
 * Leader class
 * 
 *
 */
public class Leader extends Member {
	
	private String profession;
	
	/**
	 * constructor for leader
	 * @param name the name.
	 * @param profession his job.
	 */
	public Leader(String name, String profession){
		super(name);
		this.profession = profession;
	}
	/**
	 * getter for profession
	 * @return his profession
	 */
	public String getProfession(){
		return profession;
	}
	/**
	 * setter for profession
	 * @param profession the value
	 */
	public void setProfession(String profession){
		this.profession = profession;
	}
	/**
	 * getter for name
	 * @return the name.
	 */
	public String getName(){
		return super.getName();
	}
	/**
	 * setter for name
	 * @param name the name. 
	 */
	public void setName(String name){
		super.setName(name);
	}
}
