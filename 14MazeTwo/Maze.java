import java.util.*;
import java.io.FileNotFoundException;
import java.io.*;

public class Maze{
  private Location start,end;
  private char[][] board;
  private boolean isAStar;

  public void setAStar(boolean isA){
	isAStar = isA;
  }

  public Maze(String boardText){
	ArrayList<char[]> lines = new ArrayList<char[]>();
	int startRow=-1, startCol=-1;
	int endRow=-1,endCol=-1;
	try{
	    Scanner file = new Scanner(new File(boardText));
	    while(file.hasNext()){
		lines.add(file.nextLine().toCharArray());
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: "+boardText);
	    System.exit(1);
	}
	board = new char[lines.size()][];
	for(int n = 0; n < board.length; n++){
	    board[n]=lines.get(n);
	}
	for(int r=0; r<board.length;r++){
	    for(int c=0; c<board[r].length;c++){
		if(board[r][c]=='S'){
		    if(startRow == -1){
			startRow=r;
			startCol=c;
		    }else{
			System.out.println("More than one 'S'");
			System.exit(0);
		    }
		}

		if(board[r][c]=='E'){
		    if(endRow == -1){
			endRow=r;
			endCol=c;
		    }else{
			System.out.println("More than one 'E'");
			System.exit(0);
		    }
		}
	    }
	}
	if(startRow == -1 || endRow == -1){
	    System.out.println("No 'S' or 'E' found");
	    System.exit(0);
	}
	end = new Location(endRow,endCol,null,0,0);
	start = new Location(startRow,startCol,null,0,0);
  }

  public static int getDistance(int x, int y,Location other){
      return Math.abs(x-other.getX())+Math.abs(y-other.getY());
  }

  public String toString(){
	String result = "";
	for (int r=0; r<board.length; r++){
	  for (int c=0; c<board[r].length; c++){
		result += board[r][c];
	  }
	  result += "\n";
	}
	return result;
  }
   
  public void setSpot(int r, int c, char val){
	board[r][c] = val;
  }

  public String toStringColor(){
	return "";
  }

  public Location[] getNeighbors(Location n){
    Location[] neighbors = new Location[4];
	int count=0;
	if(n.getY() + 1 < board[0].length && board[n.getX()][n.getY() + 1] == ' ' || n.getY() + 1 < board[0].length && board[n.getX()][n.getY() + 1] == 'E'){
	  if (!isAStar){
		neighbors[count] = new Location(n.getX(), n.getY() + 1,n, getDistance(n.getX(), n.getY()+1, end), 0);
	  }
	  else{
		neighbors[count] = new Location(n.getX(), n.getY() + 1,n, getDistance(n.getX(), n.getY()+1, end), n.getDistGone() + 1);
	  }
	  count++;
    }
    if(n.getY() - 1 >= 0 && board[n.getX()][n.getY() - 1] == ' ' || n.getY() - 1 >= 0 && board[n.getX()][n.getY() - 1] == 'E'){
	  if (!isAStar){
		neighbors[count] = new Location(n.getX(), n.getY() - 1,n, getDistance(n.getX(), n.getY()-1, end), 0);
	  }
	  else{
		neighbors[count] = new Location(n.getX(), n.getY() - 1,n, getDistance(n.getX(), n.getY()-1, end), n.getDistGone() + 1);
	  }
	  count++;
    }
	if(n.getX() + 1 < board.length && board[n.getX() + 1][n.getY()] == ' ' || n.getX() + 1 < board.length && board[n.getX() + 1][n.getY()] == 'E'){
      if (!isAStar){
		neighbors[count] = new Location(n.getX()+1, n.getY(),n, getDistance(n.getX()+1, n.getY(), end), 0);
	  }
	  else{
		neighbors[count] = new Location(n.getX()+1, n.getY(),n, getDistance(n.getX()+1, n.getY(), end), n.getDistGone() + 1);
	  }
	  count++;
    }
    if(n.getX() - 1 >= 0  && board[n.getX() - 1][n.getY()] == ' ' || n.getX() - 1 >= 0  && board[n.getX() - 1][n.getY()] == 'E'){
      if (!isAStar){
		neighbors[count] = new Location(n.getX()-1, n.getY(),n, getDistance(n.getX()-1, n.getY(), end), 0);
	  }
	  else{
		neighbors[count] = new Location(n.getX()-1, n.getY(),n, getDistance(n.getX()-1, n.getY(), end), n.getDistGone() + 1);
	  }
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
	Maze test = new Maze("data1.dat");
	System.out.println(test);
  }
}

