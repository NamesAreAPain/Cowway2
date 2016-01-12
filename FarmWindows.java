import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import java.util.Properties;
import java.util.Scanner; 
import java.util.*; 
import java.io.*;


public class FarmWindows{
	
	private Farm farm;
	private WSwingConsoleInterface csi;
	
	
	
	
	public FarmWindows(Farm farm){ //the windows to display each farm
		
		this.farm = farm; 
		
		//makes the window
		Properties text = new Properties();
		text.setProperty("fontSize","10");
		text.setProperty("font", "DEFAULT");
		ConsoleSystemInterface csi = null;
		
		try{
			this.csi = new WSwingConsoleInterface("My little Java Roguelike - Programming is fun", text);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
			eiie.printStackTrace();
			System.exit(-1);
		}
		this.csi.print(0,0, farm.getName(), CSIColor.WHITE); //prints the farm name
		this.csi.refresh();
		
		
		
		
	}
	
	public void updateWindow(){ //the meat of the class. Paints the array
				this.csi.print(15,1, farm.getWorld().getCalendar()[0], CSIColor.WHITE);
				
				
				
				for(int i = 0; i < farm.getDimensions()[1];i++){
					for(int j = 0; j < farm.getDimensions()[0];j++){
						
						CSIColor theC = CSIColor.WHITE;
						String theF = "a";
						
						switch(getTileType(farm.getMap()[j][i])){
							case DIRT : theC = CSIColor.BROWN; theF = "\u2588"; break; //a brown block
							case GRASS : theC = CSIColor.GREEN; theF = "\u2588"; break;
							case POISONGRASS : theC = CSIColor.PURPLE; theF = "\u2588"; break;
							case FLYINGCOW : theC = CSIColor.CYAN; theF = "\u263A"; break;
							case NOCTURNALCOW : theC = CSIColor.GRAY; theF = "\u263A"; break;
							case COW : 
							default : theC= CSIColor.BROWN; theF = "\u263A"; break; //a brown smiley face;
						}
						
						this.csi.print(i + 3, j + 3, theF, theC );
					}
				}
				this.csi.refresh();
				
				
			
	}
	
	public Tile getTileType(FarmTile aa){ //trying to get rid of the problem of null type farmTiles
		if( aa == null) return Tile.DIRT;
		return aa.getTType();
	}
	
}