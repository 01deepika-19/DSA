class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][]=new char[n][n];
        for(int i = 0;i<n;i++){
                Arrays.fill(board[i],'.');
        }
        solve(0,board,ans,n);
        return ans;
    }

    private void solve(int  row,char board[][],List<List<String>> ans,int n){

        if(row == n){
            List<String> l = new ArrayList<>();
            for(int i = 0;i<row;i++){
                l.add(new String(board[i]));
            }
            ans.add(l);
            return;
        }
        for(int col=0;col<n;col++){
            if(isSafe(row,col,board,n)){
                board[row][col]='Q';
                solve(row+1,board,ans,n);

                board[row][col]='.';
            }
        }
    }
    private boolean isSafe(int r,int c,char board[][],int n){

        for(int i = 0;i<r;i++){
            if(board[i][c]=='Q'){
                return false;
            }
        }

        for(int i = r-1,j=c-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i = r-1,j=c+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}