import java.util.Scanner; 
import java.util.*; 
import java.io.*;


public class NameGen{
	
	private String NAME;
	private String folderPath;
	
	public NameGen(String path) throws FileNotFoundException{
		
		Random rand = new Random();
		
		this.folderPath = path;
		
		File adjectives = new File(folderPath + "\\adjectives.txt");
		File nouns = new File(folderPath + "\\nouns.txt");
		
		this.NAME = "The " + nthString(random(rand,0,wordCount(adjectives)), adjectives) + " " + nthString(random(rand,0,wordCount(nouns)), nouns);
		
	}
	
	public String nthString(int n, File f) throws FileNotFoundException{
		Scanner console = new Scanner(f);
		for(int i = 0; i < n; i++ ){
			console.next();
		}
		return console.next();
	}
	
	public int wordCount(File f) throws FileNotFoundException{
		Scanner console = new Scanner(f);
		int out = 0;
		while(console.hasNext()){
			 console.next();
			 out++;
		}
		return out;
	}
	
	public int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
	
	public String getName(){
		return NAME;
	}
}