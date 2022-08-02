package offer;

public class Offer13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, m, n, 0, 0, k);
    }

    private int dfs(boolean[][] visited, int m, int n, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] == true || (sum(i) + sum(j)) > k) return 0;
        visited[i][j] = true;
        return 1 +
                dfs(visited, m, n, i + 1, j, k) +
                dfs(visited, m, n, i - 1, j, k) +
                dfs(visited, m, n, i, j + 1, k) +
                dfs(visited, m, n, i, j - 1, k);
    }

    private int sum(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
