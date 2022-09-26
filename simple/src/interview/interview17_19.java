package interview;

/**
 * @author leapord
 * @since 2022/9/26
 */
public class interview17_19 {
    /**
     * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
     * <p>
     * 以任意顺序返回这两个数字均可。
     * 示例 1:
     * <p>
     * 输入: [1]
     * 输出: [2,3]
     * 示例 2:
     * <p>
     * 输入: [2,3]
     * 输出: [1,4]
     * 提示：
     * <p>
     * nums.length <= 30000
     */
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int delta = (1 + n) * n / 2 - sum;

        int m = delta / 2;
        sum = 0;
        for (int i : nums) {
            if (i <= m) {
                sum += i;
            }
        }
        int res1 = (1 + m) * m / 2 - sum;
        int res2 = delta - res1;

        return new int[]{res1, res2};
    }
}
