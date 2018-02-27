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
	for (int n=0; n<board[0].length; n++){
	    for (int r=0; r<board.length; r++){
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
	if (row>=board.length || col>=board[0].length ||
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

    public int allSolutions(){
	int all = 0;
	for (int n=0; n<board.length; n++){
	    for (int r=0; r<board[0].length; r++){
		all += countHelp(n, r, 0, 0);
	    }
	}
	return all;
    }

    public int countSolutions(int startingRow, int startingCol){
	return countHelp(startingRow, startingCol, 0, 0);
    }

    public int countHelp(int row, int col, int sum, int level){
	if (row>=board.length || col>=board[0].length ||
	    row<0 || col<0){
	    return 0;
	}
	if (board[row][col]>0){
	    return 0;
	}
	board[row][col] = level;
	if (level == board[0].length * board.length){
	    return sum;
	}
	int num = sum;
	num += countHelp(row+2, col+1, sum, level+1);
	num += countHelp(row+2, col-1, sum, level+1);
	num += countHelp(row-2, col+1, sum, level+1);
	num += countHelp(row-2, col-1, sum, level+1);
	num += countHelp(row+1, col+2, sum, level+1);
	num += countHelp(row+1, col-2, sum, level+1);
	num += countHelp(row-1, col+2, sum, level+1);
	num += countHelp(row-1, col-2, sum, level+1);
	if (num == sum){
	    board[row][col] = 0;
        }
	return num;
    }

    public static void main(String[]args){
	KnightBoard newBoard = new KnightBoard(5,6);
	System.out.println(newBoard.countSolutions(0,0));
	System.out.println(newBoard);
    }
}
