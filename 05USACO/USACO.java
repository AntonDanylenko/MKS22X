import java.util.*;
import java.io.*;

public class USACO{
    public static int bronze(String filename){
	try{
	    File text = new File(filename);
	    Scanner reader = new Scanner(text);
	    int numRows = reader.nextInt();
	    int numCols = reader.nextInt();
	    int waterLevel = reader.nextInt();
	    int numMoves = reader.nextInt();
	    int[][] field = new int[numRows][numCols];
	    for (int r = 0; r<numRows; r++){
		for (int c=0; c<numCols; c++){
		    field[r][c] = reader.nextInt();
		}
	    }
	    /*for (int r = 0; r<numRows; r++){
		for (int c=0; c<numCols; c++){
		    System.out.println(field[r][c] + " ");
		}
		System.out.println(" ");
		}*/
	    //System.out.println(numRows + ", " + numCols);

	    
	    int[][] moves = new int[numMoves][3];
	    for (int r = 0; r<numMoves; r++){
		for (int c=0; c<3; c++){
		    moves[r][c] = reader.nextInt();
		}
	    }
	    /*for (int r = 0; r<numMoves; r++){
		for (int c=0; c<3; c++){
		    System.out.println(moves[r][c] + " ");
		}
		System.out.println(" ");
		}*/

	    
	    for (int n = 0; n<numMoves; n++){
		int maxE = 0;
		for(int r=moves[n][0]-1; r<moves[n][0]+2; r++){
		    for (int c=moves[n][1]-1; c<moves[n][1]+2; c++){
			if (field[r][c] > maxE){
			    maxE = field[r][c];
			}
		    }
		}
		int cutoff = maxE - moves[n][2];
		for(int r=moves[n][0]-1; r<moves[n][0]+2; r++){
		    for (int c=moves[n][1]-1; c<moves[n][1]+2; c++){
			if (field[r][c] > cutoff){
			    field[r][c] = cutoff;
			}
		    }
		}
	    }


	    int totalWater = 0;
	    for (int r=0; r<numRows; r++){
		for (int c=0; c<numCols; c++){
		    int volume = waterLevel - field[r][c];
		    if (volume > 0){
			field[r][c] = volume;
		    }
		    else{
			field[r][c] = 0;
		    }
		    totalWater += field[r][c];
		}
	    }

	    return totalWater * 5184;
	}
	catch (FileNotFoundException e){
	    System.out.println("Bad file >:(");
	}
	return 0;
    }

    public static void main(String[]args){
        System.out.println(bronze("makelake.in"));
    }
}
