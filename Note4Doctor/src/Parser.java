/*  --Note4Doctor File Parser--
	This file is used to parse data from a text file using key-value pairs and prints out data
	Eventually, will be expanded to place data in an object
*/
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Parser {
	private final static Charset ENCODING = StandardCharsets.UTF_8;  
	private Path textLocation;
	
	public Parser(String fileLocation){
		textLocation = Paths.get(fileLocation);
	}
	
	/** Template method that calls {@link #processLine(String)}.  */
	public final void processLineByLine() throws IOException {
		try (Scanner scanner =  new Scanner(textLocation, ENCODING.name())){
			while (scanner.hasNextLine()){
				processLine(scanner.nextLine());
			}      
		}
	}
	//Temporarily print out data, will be used to later set and return a map of key-value pairs
	//to add into an object
	protected void processLine(String aLine){
		//use a second Scanner to parse the content of each line
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter("=");
		if (scanner.hasNext()){
			//assumes the line has a certain structure
			String name = scanner.next();
			String value = scanner.next();
			log("Name is : " + quote(name.trim()) + ", and Value is : " + quote(value.trim()));
		} else {
		  log("Empty or invalid line. Unable to process.");
		}
		scanner.close();
	}
	
	private static void log(Object aObject){
		System.out.println(String.valueOf(aObject));
	}
	  
	private String quote(String aText){
		String QUOTE = "'";
		return QUOTE + aText + QUOTE;
	}
}
