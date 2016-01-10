import java.util.Scanner; 
import java.util.*; 
import java.io.*;


public enum Phrase{
	
	ADJECTIVE ("WordList\\adjectives.txt"),
	NOUN ("WordList\\nouns.txt"),
	ADVERB ("WordList\\adverbs.txt"),
	VERB ("WordList\\verbs.txt"),
	MALENAME ("WordList\\namesMale.txt"),
	FEMALENAME ("WordList\\namesFemale.txt"),
	NAME("WordList\\names.txt");
	
	private File list;
	private Random rand;
	
	Phrase(String fpath){
		this.list = new File(fpath);
		this.rand = new Random();
	}
	
	public String get() throws FileNotFoundException{
		return nthString(random(rand,0,wordCount(list)),list);
	}
	
	public String get(String imp, double chance, Random rand) throws FileNotFoundException{
		if(rand.nextFloat() < chance){
			imp = imp + nthString(random(rand,0,wordCount(list)),list);
			return imp;
		}
		return "";	
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
}
