import net.slashie.libjcsi.wswing.WSwingConsoleInterface; //import from the gui library we use. Originally for Roguelike games
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import java.util.Properties;
import java.util.Scanner; 
import java.util.*; 
import java.io.*;


public class Cowway { //This is an incredibly complex project, simulating a world of bovine farms. This is the driver class
	
	public static void main(String[] args) throws FileNotFoundException {
		//making the opening window
		
		//setting the properties
		Properties text = new Properties();
		text.setProperty("fontSize","20");
		text.setProperty("font", "DEFAULT");
		
		//makes the window
		ConsoleSystemInterface csi = null;
		try{
				csi = new WSwingConsoleInterface("My little Java Roguelike - Programming is fun", text);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
			eiie.printStackTrace();
			System.exit(-1);
		}
		//initialize the world
		World theWorld = new World(5,4,10);
		
		//prints name of the world
		csi.print(0,0, "Welcome to " + theWorld.getName(), CSIColor.GREEN);
		csi.refresh();
		
		//waits for an enter
		waitForEnter(csi);
		
		//prints opening credits
		csi.print(0,1, "A " + Phrase.ADJECTIVE.get() + " land, guided  by Adam and (somewhat) Jamie",CSIColor.CYAN);
		csi.refresh();
		
		//waits fir an enter
		waitForEnter(csi);
		
		//Introduces the farms
		csi.print(0,2, "Home to the " + Phrase.ADJECTIVE.get() + " Farms of ", CSIColor.WHITE);
		csi.refresh();
		
		waitForEnter(csi);
		
		//opens a new widow for each farm, with the name of the farm on each, as well as listing them on the main window
		FarmWindows[] windows = new FarmWindows[theWorld.getFarms().length];
		for(int i = 0; i < theWorld.getNumFarms(); i++){
			csi.print(3,3+i, theWorld.getFarms()[i].getName() + farmInfo(theWorld.getFarms()[i]) ,CSIColor.WHITE);
			csi.refresh();
			windows[i] = new FarmWindows(theWorld.getFarms()[i]);
			
		}
		//tells the program to start up
		theWorld.Genesis();
		
		
		//main operation loop
		while(true){
			try {
				Thread.sleep(100);                 //waits .1 second
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			
			theWorld.timeTick(); //ticks the time
			for(FarmWindows x : windows){
				x.updateWindow(); //updates each window
			}
		}
		

		
	}
	
	public static String farmInfo(Farm farm){ //gets how many cows, or anything else we care to add.
		String out = "(Home to " + farm.howManyCows() + " Cows)";
		return out;
	}
	
	
	public static void waitForEnter(ConsoleSystemInterface csi){ //easy wait for enter loop
		CharKey Kimp = null;
		do {
			Kimp = csi.inkey();
		} while (Kimp.code != CharKey.ENTER);
	}
	
	
}