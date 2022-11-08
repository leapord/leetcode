package question;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question1020 {
    /**
     * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
     * <p>
     * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
     * <p>
     * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 500
     * grid[i][j] 的值为 0 或 1
     */
    public int numEnclaves(int[][] grid) {
        // 广度优先搜索
        int ans = 0;

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Deque<int[]> deque = new ArrayDeque<>();
        // 所有的彼岸全部加入搜索队列中
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                visited[i][0] = true;
                deque.offer(new int[]{i, 0});
            }
            if (grid[i][n - 1] == 1) {
                visited[i][n - 1] = true;
                deque.offer(new int[]{i, n - 1});
            }
        }

        for (int i = 1; i < n; i++) {
            if (grid[0][i] == 1) {
                visited[0][i] = true;
                deque.offer(new int[]{0, i});
            }
            if (grid[m - 1][i] == 1) {
                visited[m - 1][i] = true;
                deque.offer(new int[]{m - 1, i});
            }
        }

        while (!deque.isEmpty()) {
            int[] cell = deque.poll();
            int curm = cell[0];
            int curn = cell[1];
            for (int[] direction : directions) {
                int nextm = curm + direction[0];
                int nextn = curn + direction[1];
                if (nextn >= 0 && nextn < n && nextm >= 0 && nextm < m && grid[nextm][nextn] == 1 && !visited[nextm][nextn]) {
                    visited[nextm][nextn] = true;
                    deque.offer(new int[]{nextm, nextn});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
