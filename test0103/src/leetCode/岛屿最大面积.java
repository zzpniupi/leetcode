package leetCode;

public class 岛屿最大面积 {
    public static void main(String[] args) {
        int [][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
                         {0,1,1,0,1,0,0,0,0,0,0,0,0},
                         {0,1,0,0,1,1,0,0,1,0,1,0,0},
                         {0,1,0,0,1,1,0,0,1,1,1,0,0},
                         {0,0,0,0,0,0,0,0,0,0,1,0,0},
                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
                         {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        岛屿最大面积 ins = new 岛屿最大面积();
        System.out.println(ins.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid){
        int rows = grid.length;
        int colunms = grid[0].length;
        int myGrid[][] = new int[rows][colunms];
        int count = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<colunms;j++){
                int result = isIsland(i,j,grid,myGrid);
                count = (result > count) ? result : count;
            }
        }
        return count;
    }

    public int isIsland(int row, int colunm, int[][] grid, int[][] myGrid){
        int rows = grid.length;
        int colunms = grid[0].length;
        int count = 0;
        if(row >= 0 && row < rows && colunm >= 0 && colunm <  colunms && grid[row][colunm] == 1 && myGrid[row][colunm] == 0){
            myGrid[row][colunm] = 1;
            count ++;
            count += isIsland(row,colunm + 1, grid, myGrid);
            count += isIsland(row + 1, colunm, grid, myGrid);
            count += isIsland(row,colunm - 1, grid, myGrid);
            count += isIsland(row - 1, colunm, grid, myGrid);
            return count;
        }else{
            return 0;
        }
    }
}
