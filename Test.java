import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class Test{
	
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(Phrase.ADJECTIVE.get() + " " + Phrase.NAME.get().toLowerCase() + Phrase.NOUN.get(" \"the ", 0.33, "\"") + " " + Phrase.SURNAME.get() + Phrase.ADJECTIVE.get(" the ", 0.33,""));
	}
}