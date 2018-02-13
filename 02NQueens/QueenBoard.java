public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    private boolean addQueen(int r, int c){	
	if (board[r][c]!=0){
	    return false;
	}
	for (int n=c; n<board.length; n++){
	    board[r][n]+=1;
    }
	for (int p=r; p<board.length; p++){
	    board[p][c]+=1;
    }
	for (int q=c; q<board.length; q++){
        try{
        board[r+q][c+q]+=1;
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
    }
	for (int s=c; s<board.length; s++){
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
	for (int n=c; n<board.length; n++){
	    board[r][n]-=1;
    }
	for (int p=r; p<board.length; p++){
	    board[p][c]-=1;
    }
	for (int q=c; q<board.length; q++){
        try{
        board[r+q][c+q]-=1;
        }
        catch(ArrayIndexOutOfBoundsException e){
        }
    }
	for (int s=c; s<board.length; s++){
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
		result = result +  board[r][n] + " ";
	    }
	    result += "\n";
	}
	return result;
    }

    public boolean solve(){
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
	return 0;
    }

    public static void main(String[]args){
	QueenBoard newBoard = new QueenBoard(4);
	System.out.println(newBoard.solve());
	System.out.println(newBoard);
    }
}
