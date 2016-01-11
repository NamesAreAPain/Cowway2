import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class Test{
	
	public static void main(String[] args) throws FileNotFoundException {
		for(int i = 0; i < 20; i++)
		System.out.println(Phrase.TITLE.get() + " " + Phrase.NAME.get() + " " + Phrase.SURNAME.get() + " the " + Phrase.ADJECTIVE.get() );
	}
}