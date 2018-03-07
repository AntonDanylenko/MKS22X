import java.util.*;
import java.io.*;

public class USACO{
    public static void bronze(String filename){
	try{
	    File text = new File(filename);
	    Scanner reader = new Scanner(text);
	    int numRows = reader.nextInt();
	    int numCols = reader.nextInt();
	    int waterLevel = reader.nextInt();
	    int numMoves = reader.nextInt();
	    
	    System.out.println(numRows + ", " + numCols);
	    int[][] field = new int[numRows][numCols];
	    for (int r = 
	}
	catch (FileNotFoundException e){
	    System.out.println("Bad file >:(");
	}
    }

    public static void main(String[]args){
        bronze("makelake.in");
    }
}
