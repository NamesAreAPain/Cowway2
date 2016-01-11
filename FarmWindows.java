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
	
	
	
	
	public FarmWindows(Farm farm){
		
		this.farm = farm;
		Properties text = new Properties();
		text.setProperty("fontSize","10");
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
		csi.print(0,0, farm.getName(), CSIColor.WHITE);
		int tempTime = -1;
		while(true){
			if(tempTime != )
		}
		
	}
}