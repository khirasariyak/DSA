import java.util.LinkedList;
import java.util.Queue;

/*
* https://leetcode.com/problems/rotting-oranges/
* */

public class RottenOranges {

    public int orangesRotting(int[][] mat) {
        // Code here

        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        int[] rowDir = {0, 0, +1, -1};
        int[] colDir = {+1, -1, 0, 0};

        int freshCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }

                if (mat[i][j] == 1) {
                    freshCount++;
                }

            }
        }

        int count = 0;
        int maxTime = 0;

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            int prevRow = pair.row;
            int prevCol = pair.column;
            int prevTime = pair.time;
            maxTime = Math.max(prevTime, maxTime);

            for (int k = 0; k < 4; k++) {

                int newRow = prevRow + rowDir[k];
                int newCol = prevCol + colDir[k];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] != 2 && mat[newRow][newCol] == 1) {
                    q.add(new Pair(newRow, newCol, prevTime + 1));
                    count++;
                    vis[newRow][newCol] = 2;
                }

            }

        }

        if (count != freshCount) {
            return -1;
        }

        return maxTime;
    }

    class Pair {

        int row;
        int column;
        int time;

        public Pair(int row, int column, int time) {
            this.row = row;
            this.column = column;
            this.time = time;
        }

    }

}
