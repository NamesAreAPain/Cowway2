import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class World{
	
	private int time;
	private Farm[] farms;
	private String name;
	private int minSize;
	private int maxSize;
	
	public World(int qfarms, int minSizei, int maxSizei) throws FileNotFoundException{
		Random rand = new Random();
		this.time = 0;
		this.farms = new Farm[qfarms];
		this.minSize = minSizei;
		this.maxSize = maxSizei;
		for(int i = 0; i < qfarms;i++){
			int[] dims = { random(rand,minSize, maxSize), random(rand,minSize, maxSize)};
			farms[i] = new Farm(dims);
		}
		this.name = "The " + Phrase.ADJECTIVE.get() + " " + Phrase.NOUN.get() + " of " + Phrase.ADJECTIVE.get() + " " + Phrase.NOUN.get();
	}
	
	public void timeTick(){
		time++;
	}
	
	public int whatTimeIsIt(){
		return time;
	}
	
	public Farm getFarm(int which){
		if(which < 0 || which >= farms.length){
			return null;
		}
		return farms[which];
	}
	
	public Farm[] getFarms() {
		return farms;
	}
	
	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
}