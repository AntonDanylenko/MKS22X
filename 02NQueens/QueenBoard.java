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
	return solveHelp(0);
    }
    
    private boolean solveHelp(int col){
	if (col == board.length){
	    return true;
	}
	for (int n=0; n<board.length; n++){
	    if(addQueen(n, col)){
		/*System.out.println(Text.go(1,1));
		System.out.println(this);
		Text.wait(1500); //adjust this delay*/
		if (solveHelp(col+1)){
		    return true;
		}
		removeQueen(n, col);
		/*System.out.println(Text.go(1,1));
		System.out.println(this);
		Text.wait(1500); //adjust this delay*/
	    }
	}
	return false;
    }

    public int countSolutions(){
	return 0;
    }

    public static void main(String[]args){
	QueenBoard newBoard = new QueenBoard(8);
	System.out.println(newBoard.solve());
	System.out.println(newBoard);
    }
}
