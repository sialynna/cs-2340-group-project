package classes;
import java.io.Serializable;

/**
 * Leader class, extension of Member
 *
 */
public class Leader extends Member implements Serializable {
	
	private String profession;
	
	/**
	 * Constructor for the leader
	 * @param name the name
	 * @param profession his job
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
	 * getter for name
	 * @return the name.
	 */
	public String getName(){
		return super.getName();
	}

}
