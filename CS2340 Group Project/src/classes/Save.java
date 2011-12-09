package classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Save {
	public Save(){
		
	}
	public static void save(){
		try{
		String aFile = "savefile.txt"; 
		Writer out = new BufferedWriter(new FileWriter(aFile));
			try{
				Member member1 = GameEngine.getMembers()[0];
				Member member2 = new Member("");
				Member member3 = new Member("");
				Member member4 = new Member("");
				
				if(GameEngine.getMembers().length > 1)
					member2 = GameEngine.getMembers()[1];
				if(GameEngine.getMembers().length > 2)
					member3 = GameEngine.getMembers()[2];
				if(GameEngine.getMembers().length > 3)
					member4 = GameEngine.getMembers()[3];
				
				
				System.out.println("Saving...");
				out.write(
						GameEngine.getDay() + "\n" +
						GameEngine.getMonth2() + "\n" +
						GameEngine.getPace() + "\n" +
						GameEngine.getRations() + "\n" +
						GameEngine.getLocation() + "\n" +
						member1.getName() + "\n" +
						member1.isSick() + "\n" +
						member1.getHealth() + "\n" +
						member2.getName() + "\n" +
						member2.isSick() + "\n" +
						member2.getHealth() + "\n" +
						member3.getName() + "\n" +
						member3.isSick() + "\n" +
						member3.getHealth() + "\n" +
						member4.getName() + "\n" +
						member4.isSick() + "\n" +
						member4.getHealth() + "\n" +
						GameEngine.getLeader().getName() + "\n" +
						GameEngine.getLeader().isSick() + "\n" +
						GameEngine.getLeader().getHealth() + "\n" +
						GameEngine.getLeader().getProfession() + "\n" +
						GameEngine.getSupplies().getTotalWeight() + "\n" +
						GameEngine.getSupplies().getMoney() + "\n" +
						Item.AMMO.getNum() + "\n" +
						Item.MOXEN.getNum() + "\n" +
						Item.AXLES.getNum() + "\n" +
						Item.CLOTHES.getNum() + "\n" +
						Item.MEDS.getNum() + "\n" +
						Item.RATIONS.getNum() + "\n" +
						Item.WHEELS.getNum() + "\n" +
						Item.YOKES.getNum() + "\n"
						);
				System.out.println("Saved!");
			}
		
		finally{
			out.close();
		}
		}
		catch(IOException ex){
			System.out.println("Bad save. Try again");
		}
	}
}
