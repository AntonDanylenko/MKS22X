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
	for (int r=0; r<board.length; r++){
	    for (int n=0; n<board[0].length; n++){
        if (board[r][n] == 0){
            result = result + " _ ";
        }
		else if (board[r][n] < 10){
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
        if (startingRow<0 || startingCol<0 || 
            startingRow>=board.length || startingCol>=board[0].length){
            throw new IllegalArgumentException();
        }
	    for (int r=0; r<board.length; r++){
	        for (int n=0; n<board[0].length; n++){
                if (board[r][n]!=0){
                    throw new IllegalArgumentException();
                }
            }
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






    public boolean solveFast(int startingRow, int startingCol){
        if (startingRow<0 || startingCol<0 || 
            startingRow>=board.length || startingCol>=board[0].length){
            throw new IllegalArgumentException();
        }
	    for (int r=0; r<board.length; r++){
	        for (int n=0; n<board[0].length; n++){
                if (board[r][n]!=0){
                    throw new IllegalArgumentException();
                }
            }
        }
	return solveHelpFast(startingRow, startingCol, 1);
    }

    private boolean solveHelpFast(int row, int col, int level){
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
	boolean solved = false;
	if (row+2 >= board.length - 2){
			solved = solved || solveHelpFast(row+2, col+1, level+1) || 
							   solveHelpFast(row+2, col-1, level+1);
	}
	if (row+1 < 2 || row+1 >= board.length - 2){
			solved = solved || solveHelpFast(row+1, col+2, level+1) || 
							   solveHelpFast(row+1, col-2, level+1);
	}
	if (row-2 < 2){
			solved = solved || solveHelpFast(row-2, col+1, level+1) || 
							   solveHelpFast(row-2, col-1, level+1);
	}
	if (row-1 < 2 || row-1 >= board.length - 2){
			solved = solved || solveHelpFast(row-1, col+2, level+1) || 
							   solveHelpFast(row-1, col-2, level+1);
	}


	if (row+2 < board.length - 2){
			solved = solved || solveHelpFast(row+2, col+1, level+1) || 
							   solveHelpFast(row+2, col-1, level+1);
	}
	if (row+1 >= 2 && row+1 < board.length - 2){
			solved = solved || solveHelpFast(row+1, col+2, level+1) || 
							   solveHelpFast(row+1, col-2, level+1);
	}
	if (row-2 >= 2){
			solved = solved || solveHelpFast(row-2, col+1, level+1) || 
							   solveHelpFast(row-2, col-1, level+1);
	}
	if (row-1 >= 2 && row-1 < board.length - 2){
			solved = solved || solveHelpFast(row-1, col+2, level+1) || 
							   solveHelpFast(row-1, col-2, level+1);
	}
	if (!solved){
	    board[row][col] = 0;
        }
	return solved;
    }











    public int allSolutions(){
	int all = 0;
	for (int n=0; n<board.length; n++){
	    for (int r=0; r<board[0].length; r++){
		all += countHelp(n, r, 0, 1);
	    }
	}
	return all;
    }

    public int countSolutions(int startingRow, int startingCol){
        if (startingRow<0 || startingCol<0 || 
            startingRow>=board.length || startingCol>=board[0].length){
            throw new IllegalArgumentException();
        }
	    for (int r=0; r<board.length; r++){
	        for (int n=0; n<board[0].length; n++){
                if (board[r][n]!=0){
                    throw new IllegalArgumentException();
                }
            }
        }
	return countHelp(startingRow, startingCol, 0, 1);
    }

    private int countHelp(int row, int col, int sum, int level){
	if (row>=board.length || col>=board[0].length ||
	    row<0 || col<0){
	    return 0;
	}
	if (board[row][col]>0){
	    return 0;
	}
	board[row][col] = level;
	if (level == board[0].length * board.length){
	    board[row][col] = 0;
	    return 1;
	}
	sum += countHelp(row+2, col+1, 0, level+1);
	sum += countHelp(row+2, col-1, 0, level+1);
	sum += countHelp(row-2, col+1, 0, level+1);
	sum += countHelp(row-2, col-1, 0, level+1);
	sum += countHelp(row+1, col+2, 0, level+1);
	sum += countHelp(row+1, col-2, 0, level+1);
	sum += countHelp(row-1, col+2, 0, level+1);
	sum += countHelp(row-1, col-2, 0, level+1);
	board[row][col] = 0;
	return sum;
    }

    public static void main(String[]args){
	KnightBoard newBoard2 = new KnightBoard(7,7);
	final long startTime2 = System.currentTimeMillis();
	System.out.println(newBoard2.solve(0,0));
	final long endTime2 = System.currentTimeMillis();
	System.out.println("Total execution time: " + (endTime2 - startTime2) );
	System.out.println(newBoard2);

	KnightBoard newBoard1 = new KnightBoard(7,7);
	final long startTime = System.currentTimeMillis();
	System.out.println(newBoard1.solveFast(0,0));
	final long endTime = System.currentTimeMillis();
	System.out.println("Total execution time: " + (endTime - startTime) );
	System.out.println(newBoard1);
    }
}
