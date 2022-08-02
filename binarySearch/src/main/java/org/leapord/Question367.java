package org.leapord;

/**
 * @author leapord
 * @since 2022/8/2
 */
public class Question367 {

    /**
     * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * <p>
     * 进阶：不要 使用任何内置的库函数，如  sqrt 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-perfect-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
