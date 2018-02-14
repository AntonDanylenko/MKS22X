public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
        if (startingRows<0 || startingCols<0){
            throw new IllegalArgumentException();
        }
        board = new int[startingRows][startingCols];
    }

    public String toString(){
    }

    public boolean solve(int startingRow, int startingCol){
        if (startingRows<0 || startingCols<0){
            throw new IllegalArgumentException();
        }
	return solveHelp(startingRow, startingCol, 0);
    }

    private boolean solveHelp(int row, int col, int level){
	if (level == row * col -1){
	    return true;
	}
	
    }

    public boolean countSolutions(int startingRow, int startingCol){
	if (startingRows<0 || startingCols<0){
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[]args){
    }
}
