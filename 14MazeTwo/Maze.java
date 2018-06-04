import java.util.*;
import java.io.*;

public class Maze{
  private Location start,end;
  private char[][] board;
  private int maxrows, maxcols;

  public Maze(String mazeText){
	maxcols = mazeText.indexOf('\n');
	for (int n=0; n<mazeText.length(); n++){
		if (mazeText.charAt(n) == '\n'){
			maxrows++;
		}
	}
	System.out.println("Cols: " + maxcols + ", Rows: " + maxrows);
	board = new char[maxrows][maxcols];
	for (int r=0; r<maxrows; r++){
		for (int c=0; c<maxcols; c++){
			char temp = mazeText.charAt(r*(maxcols+1)+c);
			if (temp=='S'){
				start = new Location(c,r, null);
			}
			else if(temp=='E'){
				end = new Location(c,r, null);
			}
			board[r][c] = temp;
		}
	}
	for (int n=0; n<board.length; n++){
		System.out.println(Arrays.toString(board[n]));
	}
  }

  // '#' - wall 
  // ' ' - open space
  // '?' - frontier space
  // '.' - visited space
  // 'E' - end space (do not replace this)
  // '@' - part of solution
  // 'S' - starting space (do not replace this)
  public String toString(){
	String result = "";
	for (int n=0; n<board.length; n++){
		result = result + Arrays.toString(board[n]) + "\n";
	}
	return result;
  }
   
  // Work on this method as a group! 
  public String toStringColor(){
	return "";
  }

  //return a list of Locations that are:
  // adjacent to n and  not visited
  // all the Locations in this list should have their previous set to n.
  public Location[] getNeighbors(Location n){
    Location[] neighbors = new Location[4];
	int count=0;
	if(n.getY() + 1 < board[0].length && board[n.getX()][n.getY() + 1] == ' ' || n.getY() + 1 < board[0].length && board[n.getX()][n.getY() + 1] == 'E'){
	  neighbors[count] = new Location(n.getX(), n.getY() + 1, n);
	  count++;
    }
    if(n.getY() - 1 >= 0 && board[n.getX()][n.getY() - 1] == ' ' || n.getY() - 1 >= 0 && board[n.getX()][n.getY() - 1] == 'E'){
	  neighbors[count] = new Location(n.getX(), n.getY() - 1, n);
	  count++;
    }
	if(n.getX() + 1 < board.length && board[n.getX() + 1][n.getY()] == ' ' || n.getX() + 1 < board.length && board[n.getX() + 1][n.getY()] == 'E'){
      neighbors[count] = new Location(n.getX() + 1, n.getY(), n);
	  count++;
    }
    if(n.getX() - 1 >= 0  && board[n.getX() - 1][n.getY()] == ' ' || n.getX() - 1 >= 0  && board[n.getX() - 1][n.getY()] == 'E'){
      neighbors[count] = new Location(n.getX() - 1, n.getY(), n);
    }
    return neighbors;
  }

  public Location getStart(){
    return start;
  }

  public Location getEnd(){
    return end;
  }

  public static void main(String[]args) throws FileNotFoundException{
	File text = new File("data1.dat");
    Scanner reader = new Scanner(text);
	String file = "";
	while (reader.hasNextLine()){
		String line = reader.nextLine();
	    file += line;
		file += "\n";
	}
	System.out.println(file);
	Maze test = new Maze(file);
  }
}

