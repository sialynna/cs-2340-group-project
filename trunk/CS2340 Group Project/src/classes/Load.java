package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Load {
	public Load(){
		
	}
	
	public static void load(){
		System.out.println("Loading...");
		int i = 0;
		String[] array = new String[35]; //30
		String aFile = "savefile.txt";
		try{
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			String line = input.readLine();
			while(line != null){
				array[i] = line;
				System.out.println(array[i]);
				line = input.readLine();
				i++;
			}
		
			
			if(array[2].equals("Stopped"))
			{
				GameEngine.pace.setPace(0);
			}
			else if(array[2].equals("Easy"))
			{
				GameEngine.pace.setPace(1);
			}
			else if(array[2].equals("Normal"))
			{
				GameEngine.pace.setPace(2);
			}
			else if(array[2].equals("Grueling"))
			{
				GameEngine.pace.setPace(3);
			}
			Rations rations = new Rations();
			
			if(rations.equals("Filling"))
			{
				GameEngine.rations.setRations(3);
			}
			else if(rations.equals("Normal"))
			{
				GameEngine.rations.setRations(2);
			}
			else if(rations.equals("Meager"))
			{
				GameEngine.rations.setRations(1);
			}
			else if(rations.equals("Starvation"))
			{
				GameEngine.rations.setRations(0);
			}
			Location location = new Location(Double.parseDouble(array[4]), GameEngine.pace);
			GameEngine.setMembers(array[5], array[8], array[11], array[14]);
			Leader leader = new Leader(array[17], array[20]);
			GameEngine.setLeader2(leader);
			//setup Items
			Item.AMMO.setNum(Integer.parseInt(array[23]));
			Item.MOXEN.setNum(Integer.parseInt(array[24]));
			Item.AXLES.setNum(Integer.parseInt(array[25]));
			Item.CLOTHES.setNum(Integer.parseInt(array[26]));
			Item.MEDS.setNum(Integer.parseInt(array[27]));
			Item.RATIONS.setNum(Integer.parseInt(array[28]));
			Item.WHEELS.setNum(Integer.parseInt(array[29]));
			Item.YOKES.setNum(Integer.parseInt(array[30]));
			
			//Set supplies
			Supplies supplies = new Supplies(array[20]);
			supplies.setMoney(Integer.parseInt(array[22]));
			supplies.setWeight(Integer.parseInt(array[21]));
			System.out.println(GameEngine.getMembers().length);
			//set health
			GameEngine.getMembers()[0].setHealth(Integer.parseInt(array[7]));
			if(GameEngine.getMembers().length > 1)
				GameEngine.getMembers()[1].setHealth(Integer.parseInt(array[10]));
			if(GameEngine.getMembers().length > 2)
				GameEngine.getMembers()[2].setHealth(Integer.parseInt(array[13]));
			if(GameEngine.getMembers().length > 3)
				GameEngine.getMembers()[3].setHealth(Integer.parseInt(array[16]));
			
			GameEngine.getLeader().setHealth(Integer.parseInt(array[19]));
			
			GameEngine.setLocation(location);
			GameEngine.setSupplies(supplies);
			GameEngine.setDay(Integer.parseInt(array[0]));
			GameEngine.setMonth(Integer.parseInt(array[1]));
			GameEngine.gameYear = 2012;
			
			GameEngine.setPanelMain();
		}
		catch(IOException ex){
			System.out.println("Error loading");
		}



	}
}
