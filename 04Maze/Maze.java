import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 

         throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename) throws FileNotFoundException{
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
	//System.out.println(file);
	//System.out.println("NumRows: " + numRows + "\nNumCols: " + numCols);


	maze = new char[numRows][numCols];

	
	for (int r=0; r<numRows; r++){
		for (int c=0; c<numCols; c++){
			maze[r][c] = file.charAt(r*numCols + c);
		}
	}

	/*for (int r=0; r<numRows; r++){
		String line = "";
	    for (int c=0; c<numCols; c++){
			line += maze[r][c];
		}
		System.out.println(line);
	}*/
    

	int numS = 0;
	int numE = 0;
	for (int r=0; r<numRows; r++){
	    for (int c=0; c<numCols; c++){
		if (maze[r][c] == 'S'){
		    numS++;
		}
		else if(maze[r][c] == 'E'){
		    numE++;
		}
	    }
	}
	//System.out.println("NumS: " + numS + "\nNumE: " + numE);
	if (numS!=1 || numE!=1){
	    throw new IllegalStateException();
	}
    }
    

    
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    
    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){
	int row = 0;
	int col = 0;
	for (int r=0; r<maze.length; r++){
	    for (int c=0; c<maze[0].length; c++){
			if(maze[r][c] == 'S'){
				row = r;
				col = c;
				maze[r][c] = ' ';
			}
		}
	}

	for (int r=0; r<maze.length; r++){
		String line = "";
	    for (int c=0; c<maze[0].length; c++){
			line += maze[r][c];
		}
		System.out.println(line);
	}
	return solve(row,col);
    }


    
    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private


        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //COMPLETE SOLVE

        return -1; //so it compiles
    }


    
    public static void main(String[]args){
	try{
	Maze m1 = new Maze("data1.txt");
	m1.solve();
	}
	catch(FileNotFoundException e){
	    System.out.println("There is no file");
	}
    }
}
