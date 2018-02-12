public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    private boolean addQueen(int r, int c){	
	/*for(int n=0; n<board[r].length; n++){
	    board[r][n] += 1;
	}
        int p=0;
	int q=0;
	while(p<board.length){
	    board[p][q] +=1;
	    p++;
	    q++;
	}
	board[r][c] = -1;*/
	if (board[r][c]!=0){
	    return false;
	}
	for (int n=0; n<board.length; n++){
	    board[r][n]+=1;
	    board[n][c]+=1;
	}
	//for (int p=0; p<board.length; p++){
	//}
	board[r][c] = -1;
	return true;
    }

    private boolean removeQueen(int r, int c){
	if (board[r][c]!=-1){
	    return false;
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
    
    public boolean solveHelp(int col){
	/*for(int p=0; p<board.length; p++){
	    for (int q=0; q<board.length; q++){
		if (board[p][q]==0){
		    addQueen(p,q);
		    q=0;
		    p+=1;
		}
	    }
	    }*/
	if (col == board.length){
	    return true;
	}
	for (int n=0; n<board.length; n++){
	    addQueen(n, col);
	    if (solveHelp(col+1)){
		return true;
	    }
	    removeQueen(n, col);
	}
	return false;
    }

    public int countSolutions(){
	return 0;
    }

    public static void main(String[]args){
	QueenBoard newBoard = new QueenBoard(8);
	newBoard.solve();
	System.out.println(newBoard);
    }
}
