public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
        if (startingRows<0 || startingCols<0){
            throw new IllegalArgumentException();
        }
        board = new int[startingRows][startingCols];
    }

    public String toString(){
	String result = "";
	for (int n=0; n<board.length; n++){
	    for (int r=0; r<board[0].length; r++){
		if (board[r][n] < 10){
		    result = result + " " + board[r][n] + " ";
		}
		else{
		    result = result + board[r][n] + " ";
		}
	    }
	    result += "\n";
	}
	return result;
    }

    public boolean solve(int startingRow, int startingCol){
        if (startingRow<0 || startingCol<0){
            throw new IllegalArgumentException();
        }
	return solveHelp(startingRow, startingCol, 1);
    }

    private boolean solveHelp(int row, int col, int level){
	if (row>=board[0].length || col>=board.length ||
	    row<0 || col<0){
	    return false;
	}
	if (board[row][col]>0){
	    return false;
	}
	board[row][col] = level;
	if (level == board[0].length * board.length){
	    return true;
	}
	boolean solved =  solveHelp(row+2, col+1, level+1) ||
	       solveHelp(row+2, col-1, level+1) ||
	       solveHelp(row-2, col+1, level+1) ||
	       solveHelp(row-2, col-1, level+1) ||
	       solveHelp(row+1, col+2, level+1) ||
	       solveHelp(row+1, col-2, level+1) ||
	       solveHelp(row-1, col+2, level+1) ||
	       solveHelp(row-1, col-2, level+1);
	if (!solved){
	    board[row][col] = 0;
        }
	return solved;
    }

    public boolean countSolutions(int startingRow, int startingCol){
	if (startingRow<0 || startingCol<0){
            throw new IllegalArgumentException();
        }
	return true;
    }

    public static void main(String[]args){
	KnightBoard newBoard = new KnightBoard(4,4);
	System.out.println(newBoard.solve(0,0));
	System.out.println(newBoard);
    }
}
