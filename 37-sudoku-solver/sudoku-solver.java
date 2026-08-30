class Solution {
    public void solveSudoku(char[][] board) {
       solve(board);   
    }
    private boolean solve(char board[][]){

        for(int row = 0;row < 9;row++){
            for(int col = 0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char c = '1';c<='9';c++){
                        if(isSafe(row,col,c,board)){
                            board[row][col]=c;
                            if(solve(board)){
                                return true;
                            }
                            board[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isSafe(int row,int col,char c,char board[][]){

        for(int i = 0;i<9;i++){
            if(board[row][i]==c || board[i][col]==c){
                return false;
            }
        }
        int startrow = (row/3)*3;
        int startcol = (col/3)*3;
        for(int i = startrow;i<startrow+3;i++){
            for(int j = startcol;j<startcol+3;j++){
                if(board[i][j]==c){
                    return false;
                }
            }
        }
        return true;
    }
}