package classes;

public class Leader extends Member {
	private String profession;
	
	public Leader(String name, String profession){
		super(name);
		this.profession = profession;
	}
	
	
	public String getProfession(){
		return profession;
	}
	public void setProfession(String profession){
		this.profession = profession;
	}
	public String getName(){
		return super.getName();
	}
	public void setName(String name){
		super.setName(name);
	}
}
