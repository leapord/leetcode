package InterviewPlan;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author leapord
 * @since 2022/9/15
 */
public class Question994 {
    /**
     * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
     * <p>
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
     * <p>
     * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 10
     * grid[i][j] 仅为 0、1 或 2
     */
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int ans = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>(16);

        // 初始所有的起点位置到队列
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (grid[r][c] == 2) {
                    int code = r * column + c;
                    queue.offer(code);
                    depth.put(code, 0);
                }
            }
        }

        // 深度搜索
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int r = code / column;
            int c = code % column;
            for (int i = 0; i < 4; i++) {
                int nextRow = r + dr[i];
                int nextColumn = c + dc[i];
                if (nextRow >= 0 && nextRow < row && nextColumn >= 0 && nextColumn < column && grid[nextRow][nextColumn] == 1) {
                    grid[nextRow][nextColumn] = 2;
                    int nextCode = nextRow * column + nextColumn;
                    queue.offer(nextCode);
                    depth.put(nextCode, depth.get(code) + 1);
                    ans = depth.get(nextCode);
                }
            }
        }

        for (int[] rows : grid) {
            for (int c : rows) {
                if (c == 1) {
                    return -1;
                }
            }
        }

        return ans;
    }
}
