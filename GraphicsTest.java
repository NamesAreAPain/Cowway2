import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.CSIColor;
import java.util.Properties;
import java.util.Scanner; 
import java.util.*; 
import java.io.*;


public class GraphicsTest{
	
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


		
	}
	
}