package InterviewPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leapord
 * @since 2022/9/16
 */
public class Question417 {
    /**
     * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
     * <p>
     * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
     * <p>
     * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
     * <p>
     * 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/pacific-atlantic-water-flow
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        //pacific
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        for (int i = 1; i < n; i++) {
            dfs(0, i, pacific);
        }

        //atlantic
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }

        for (int i = 0; i < n; i++) {
            dfs(m - 1, i, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] ocean) {
        if (ocean[r][c]) {
            return;
        }
        ocean[r][c] = true;
        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean);
            }

        }
    }

    private int[][] heights;
    private int m;
    private int n;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Question417 test = new Question417();
        System.out.println(test.pacificAtlantic(new int[][]{
                {2, 1},
                {1, 2}
        }));
    }
}
