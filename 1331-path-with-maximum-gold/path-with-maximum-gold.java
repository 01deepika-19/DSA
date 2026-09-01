class Solution {
    private int maxGold=0;
    public int getMaximumGold(int[][] grid) {
        
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    dfs(i,j,grid,0);
                }
            }
        }
        return maxGold;
    }
    private void dfs(int r,int c,int grid[][],int gold){

        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0){
            return;
        }
        
        int currentGold = grid[r][c];
        gold+=currentGold;
        maxGold=Math.max(gold,maxGold);

        int dr[]={0,0,-1,1};
        int dc[] ={1,-1,0,0};
        
        grid[r][c]=0;

        for(int i = 0;i<4;i++){
            int newRow= r+dr[i];
            int newCol= c+dc[i];
            dfs(newRow, newCol, grid, gold);
        }
        grid[r][c]=currentGold;
    }
}