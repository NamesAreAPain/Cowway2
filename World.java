import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class World{ // Generates An array of farms, and holds time data
	
	private int time; //the net time, ticks up from 0
	private int timeOfDay; //the time in military time, 0-24
	private Farm[] farms; //the array of farms
	private String name; //the name of the world
	private int minSize; //minimum side length of a farm
	private int maxSize; //max side length of a farm
	private int numfarms; //number of farms
	private String[] Calendar;
	
	public World(int qfarms, int minSizei, int maxSizei) throws FileNotFoundException{ //generates all the farms, starts up time;
		Random rand = new Random();
		this.numfarms = qfarms;
		this.time = 0;
		this.farms = new Farm[qfarms];
		this.minSize = minSizei;
		this.maxSize = maxSizei;
		for(int i = 0; i < qfarms;i++){ //generates the farms
			int[] dims = { random(rand,minSize, maxSize), random(rand,minSize, maxSize)};
			farms[i] = new Farm(dims,this);
		}
		this.name = "The " + Phrase.ADJECTIVE.get() + " " + Phrase.NOUN.get() + " of " + Phrase.ADJECTIVE.get() + " " + Phrase.NOUN.get(); 
		this.Calendar = new String[13];
		
		this.Calendar[0] = "Year 0"
		for(int i = 1; i < 13; i++){
			Calendar[i] = "The Month of " + Phrase.INGVERB.get() 
		}
		//makes the name using the custom enum type Phrase
	}
	
	public void Genesis(){ //tells the farms to Generate
		for(Farm x : farms){
			x.Genesis();
		}
	}
	
	public int getNumFarms(){ //how many farms?
		return numfarms;
	}
	
	public void timeTick(){ //ticks the world
		time++;
		timeOfDay = time % 24;
		this.Calendar[0] = "Year " + time/24/336;
		for(Farm x: farms){ //ticks each farm
			x.tick();
		}
	}
	
	public int whatTimeIsIt(){ //getTime
		return time;
	}
	
	public int whatTimeOfDay(){ //get time of day
		return timeOfDay;
	}
	
	public Farm getFarm(int which){ //retrieves a farm
		if(which < 0 || which >= farms.length){
			return null;
		}
		return farms[which];
	}
	
	public Farm[] getFarms() { //returns an array of the farms
		return farms;
	}
	
	public String[] getCalendar(){
		return Calendar;
	}
	public String getName(){ //returns the name
		return name;
	}
	
	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
}