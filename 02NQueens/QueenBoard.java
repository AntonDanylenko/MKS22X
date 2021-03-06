public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    private boolean addQueen(int r, int c){	
	if (board[r][c]!=0){
	    return false;
	}
	for (int n=0; n<board.length; n++){
	    board[r][n]+=1;
    }
	for (int p=0; p<board.length; p++){
	    board[p][c]+=1;
    }
	for (int q=0; q<board.length; q++){
        try{
        board[r+q][c+q]+=1;
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
    }
	for (int s=0; s<board.length; s++){
        try{
        board[r-s][c+s]+=1;
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
	}
	board[r][c] = -1;
	return true;
    }

    private boolean removeQueen(int r, int c){
	if (board[r][c]!=-1){
	    return false;
	}
	for (int n=0; n<board.length; n++){
	    board[r][n]-=1;
    }
	for (int p=0; p<board.length; p++){
	    board[p][c]-=1;
    }
	for (int q=0; q<board.length; q++){
        try{
        board[r+q][c+q]-=1;
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
    }
	for (int s=0; s<board.length; s++){
        try{
        board[r-s][c+s]-=1;
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
	}
	board[r][c] = 0;
	return true;
    }

    public String toString(){
	String result = "";
	for (int n=0; n<board.length; n++){
	    for (int r=0; r<board.length; r++){
		if (board[r][n]!=-1){
		    result = result + "_ ";
		}
		else{
		    result = result + "Q ";
		}
	    }
	    result += "\n";
	}
	return result;
    }

    public boolean solve(){
    for (int n=0; n<board.length; n++){
        for (int r=0; r<board.length; r++){
            if(board[n][r]!=0){
                throw new IllegalStateException();
            }
        }
    }
	return solveHelp(0);
    }
    
    private boolean solveHelp(int col){
	if (col == board.length){
	    return true;
	}
	for (int n=0; n<board.length; n++){
	    if(addQueen(n, col)){
		if (solveHelp(col+1)){
		    return true;
		}
		removeQueen(n, col);
	    }
	}
	return false;
    }

    public int countSolutions(){
    for (int n=0; n<board.length; n++){
        for (int r=0; r<board.length; r++){
            if(board[n][r]!=0){
                throw new IllegalStateException();
            }
        }
    }
	return countHelp(0, 0);
    }

    private int countHelp(int col, int sum){
	if (col == board.length){
	    return 1;
	}
	for (int n=0; n<board.length; n++){
	    if(addQueen(n, col)){
		int num = countHelp(col+1, 0);
		if (num>0){
		    sum+=num;
		}
		removeQueen(n, col);
	    }
	}
	return sum;
    }

    /*public static void main(String[]args){
	QueenBoard newBoard = new QueenBoard(4);
	System.out.println(newBoard.solve());
	System.out.println(newBoard);
    }*/
}
