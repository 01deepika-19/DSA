class Solution {
    private int count =0;
    public int uniquePathsIII(int[][] grid) {
        int emptyCell = 0;
        int startRow=0,startCol=0;

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    startRow=i;
                    startCol=j;
                }
                if(grid[i][j] != -1){
                    emptyCell++;
                }
            }
        }
        dfs(1,startRow,startCol,emptyCell,grid);
        return count;
    }

    private void dfs(int visited,int r,int c,int emptyCells,int grid[][]){
        
        if(grid[r][c]==2){
            if(visited==emptyCells){
            count++;
            }
        return;
        }

        int temp = grid[r][c];
        grid[r][c]=-1;

        int rowDir[]={0,0,-1,1};
        int colDir[]={1,-1,0,0};

        for(int i = 0;i<4;i++){
            int newRow = r+rowDir[i];
            int newCol = c+colDir[i];

            if(newRow >= 0 && newRow < grid.length && newCol >=0 && newCol<grid[0].length && grid[newRow][newCol] != -1){
                dfs(visited+1,newRow,newCol,emptyCells,grid);
            }
        }
        grid[r][c]=temp;
    }
}