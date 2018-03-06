import java.util.*;
import java.io.*;

public class USACO{
    public static void bronze(String filename){
        File text = new File(filename);
        Scanner reader = new Scanner(text);
	//System.out.println(reader);
	String file = "";
	int numRows = 0;
	int numCols = 0;
	while (reader.hasNextLine()){
		String line = reader.nextLine();
		//System.out.println(line);
		numCols = line.length();
		numRows++;
	    file += line;
        }
    }
}
