package question;

/**
 * @author leapord
 * @since 2022/8/3
 */
public class Question977 {

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     */

    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int left = 0;
        int rigth = length - 1;
        int cursor = length - 1;
        while (left <= rigth) {
            if (nums[left] * nums[left] < nums[rigth] * nums[rigth]) {
                ans[cursor] = nums[rigth] * nums[rigth];
                rigth--;
            } else {
                ans[cursor] = nums[left] * nums[left];
                left++;
            }
            cursor--;
        }

        return ans;
    }
}
