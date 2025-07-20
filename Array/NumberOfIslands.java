package Array;

/*
* https://leetcode.com/problems/number-of-islands/description/
* */

public class NumberOfIslands {

    private static int n;
    private static int m;
    private static int count = 0;

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numberOfIslands(grid));
    }

    public static int numberOfIslands(char[][] grid) {

        n = grid.length;
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {

        // if grid[i][j] is water or visited, return 0
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }

        // mark grid[i][j] as visited
        grid[i][j] = '2';

        // visit all 4 directions
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
    
}
