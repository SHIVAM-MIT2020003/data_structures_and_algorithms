package find_path;

class Solution{
    public static void main(String[]args){
        boolean[][] grid = new boolean[1000][1000];

        int paths = path2(grid, 0, 0);
        System.out.println(paths);
    }


    //using memoization.

    public static int path2(boolean[][] grid, int  row, int col){
        int[][] nums = new int[grid.length + 1][grid[0].length + 1];
        nums[nums.length - 2][nums[0].length - 1] = 1;

        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = nums[0].length - 2; j >= 0; j--){
                nums[i][j] = nums[i][j + 1] + nums[i + 1][j];
            }
        }
        return nums[0][0];
    }

    //recursive approach
    public static int path1(boolean[][] grid, int row, int col){
        if(!isValidPath(grid, row,  col))
            return 0;
        else if(grid[row][col])
            return 0;
        else if(isEndOfSquare(grid, row, col))
            return 1;

        return path1(grid, row + 1, col) + path1(grid, row, col + 1);

    }

    public static boolean isValidPath(boolean[][] grid, int row, int column){
        if(row >= grid.length || column >= grid[0].length){
            return false;
        }else{
            return true;
        }
    }

    public static boolean isEndOfSquare(boolean[][] grid, int row, int column){
        if(row == grid.length - 1 && column == grid[0].length - 1){
            return true;
        }else{
            return false;
        }
    }
}