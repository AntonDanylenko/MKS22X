public class QueenBoard{
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    private boolean addQueen(int r, int c){	
	for(int n=0; n<board[r].length; n++){
	    board[r][n] += 1;
	}
        int p=0;
	int q=0;
	while(p<board.length){
	    board[p][q] +=1;
	    p++;
	    q++;
	}
	board[r][c] = -1;
    }

    private boolean removeQueen(int r, int c){
    }

    public String toString(){
    }

    public boolean solve(){
	 for(int p=0; p<board.length; p++){
	    for (int q=0; q<board.length; q++){
		if (board[p][q]==0){
		    addQueen(p,q);
		    q=0;
		    p+=1;
		}
	    }
	 }
    }

    public int countSolutions(){
    }
    
}
