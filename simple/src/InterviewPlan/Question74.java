package InterviewPlan;

/**
 * @author leapord
 * @since 2022/9/14
 */
public class Question74 {
    /**
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * <p>
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     *  
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/search-a-2d-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchColumn(matrix, target);
        if (row == -1) {
            return false;
        }
        return binarySearchRow(matrix, row, target);
    }

    private boolean binarySearchRow(int[][] matrix, int row, int target) {
        int left = 0;
        int right = matrix[row].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    private int binarySearchColumn(int[][] matrix, int target) {
        int left = -1;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (matrix[mid][0] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
