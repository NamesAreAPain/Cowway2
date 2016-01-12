import java.util.Scanner; 
import java.util.*; 
import java.io.*;


public class Record{
	
	private ArrayList<String> history;
	
	public Record(){
		this.history= new ArrayList<String>();
	}
	public void addRecord(String x){
		this.history.add(x);
		System.out.println(x);
	}
}