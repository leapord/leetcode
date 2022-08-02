package offer;

import java.util.Arrays;

/**
 * @author leapord
 * @since 2022/7/23
 */
public class Offer59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int length = nums.length;
        int[] res = new int[length - k + 1];
        for (int i = 0; i < length - k; i++) {
            res[i] = getMax(Arrays.copyOfRange(nums, i, i + k));
        }
        return res;
    }

    int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }
}
