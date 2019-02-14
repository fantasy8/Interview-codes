/**
 * MinimumPathSum
 */
class MinimumPathSum {
  /**
   * 
   * @param grid
   * @return
   */
  public int minPathSum(int[][] grid) {
    if(grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }
    int[][] mem = new int[grid.length + 1][grid[0].length + 1];
    for(int i = 0; i < grid.length; i++) {
      mem[i][0] = 0;
    }
    for(int j = 0; j < grid[0].length; j++) {
      mem[0][j] = 0;
    }

    for(int j = 1; j <= grid[0].length; j++) {
      for(int i = 1; i <= grid.length; i++) {
        if(j == 1) {
          mem[i][j] = mem[i -1][j] + grid[i - 1][j - 1];
        } else if (i  == 1) {
          mem[i][j] = mem[i][j - 1] + grid[i - 1][j - 1];
        } else {
          mem[i][j] = Math.min(mem[i - 1][j], mem[i][j - 1]) + grid[i - 1][j - 1];
        }
      }
    }

    return mem[grid.length][grid[0].length];
  }
}
