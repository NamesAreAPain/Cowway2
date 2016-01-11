import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import java.util.Properties;
import java.util.Scanner; 
import java.util.*; 
import java.io.*;


public class Cowway{
	
	public static void main(String[] args) throws FileNotFoundException {
		Properties text = new Properties();
		text.setProperty("fontSize","20");
		text.setProperty("font", "DEFAULT");
		
		ConsoleSystemInterface csi = null;
		try{
				csi = new WSwingConsoleInterface("My little Java Roguelike - Programming is fun", text);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
			eiie.printStackTrace();
			System.exit(-1);
		}
		
		World theWorld = new World(5,4,10);
		
		csi.print(0,0, "Welcome to " + theWorld.getName(), CSIColor.GREEN);
		csi.refresh();
		
		waitForEnter(csi);
		
		csi.print(0,1, "A " + Phrase.ADJECTIVE.get() + " land, guided  by Jamie and (somewhat) Adam",CSIColor.CYAN);
		csi.refresh();
		
		waitForEnter(csi);
		
		csi.print(0,2, "Home to the " + Phrase.ADJECTIVE.get() + " Farms of ", CSIColor.WHITE);
		
		FarmWindows[] windows = new FarmWindows[theWorld.getFarms().length];
		
		for(int i = 0; i < theWorld.getFarms().length; i++){
			csi.print(3,3+i, theWorld.getFarms()[i].getName() + farmInfo(theWorld.getFarms()[i]) ,CSIColor.WHITE);
			windows[i] = new FarmWindows(theWorld.getFarms()[i]);
			csi.refresh();
		}
		
		

		
	}
	
	public static String farmInfo(Farm farm){
		String out = "(Home to " + farm.howManyCows() + " Cows)";
		return out;
	}
	
	
	public static void waitForEnter(ConsoleSystemInterface csi){
		CharKey Kimp = null;
		do {
			Kimp = csi.inkey();
		} while (Kimp.code != CharKey.ENTER);
	}
	
	
}