package InterviewPlan;

import java.util.Arrays;

/**
 * @author leapord
 * @since 2022/8/27
 */
public class Question733 {
    /**
     * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。
     * <p>
     * 你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充 。
     * <p>
     * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为 newColor 。
     * <p>
     * 最后返回 经过上色渲染后的图像 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/flood-fill
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int source = image[sr][sc];
        image[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;
        int[][] path = new int[m][n];
        path[sr][sc] = 1;
        dfs(image, path, m, n, source, color, sr + 1, sc);
        dfs(image, path, m, n, source, color, sr - 1, sc);
        dfs(image, path, m, n, source, color, sr, sc + 1);
        dfs(image, path, m, n, source, color, sr, sc - 1);
        return image;
    }

    private void dfs(int[][] image, int[][] path, int m, int n, int source, int color, int sr, int sc) {

        if (sr < m && sr >= 0 && sc < n && sc >= 0 && (image[sr][sc] == source) && path[sr][sc] == 0) {
            image[sr][sc] = color;
            path[sr][sc] = 1;
            dfs(image, path, m, n, source, color, sr + 1, sc);
            dfs(image, path, m, n, source, color, sr - 1, sc);
            dfs(image, path, m, n, source, color, sr, sc + 1);
            dfs(image, path, m, n, source, color, sr, sc - 1);
        }
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{{0, 0, 0}, {0, 0, 0}};
        Question733 question733 = new Question733();
        question733.floodFill(image, 0, 0, 0);
    }

}
