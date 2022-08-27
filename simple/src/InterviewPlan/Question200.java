package InterviewPlan;

/**
 * @author leapord
 * @since 2022/8/27
 */
public class Question200 {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 输出：3
     *  
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numIslands(char[][] grid) {
        // 先找到岛屿
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    // 填充已找到的岛屿防止重复查找
                    dfs(grid, m, n, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int m, int n, int i, int j) {
        if (i >= m || i < 0 || j >= n || j < 0) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = 0;
            dfs(grid, m, n, i - 1, j);
            dfs(grid, m, n, i + 1, j);
            dfs(grid, m, n, i, j - 1);
            dfs(grid, m, n, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}
        };
        Question200 question200 = new Question200();
        System.out.println(question200.numIslands(grid));
    }
}
