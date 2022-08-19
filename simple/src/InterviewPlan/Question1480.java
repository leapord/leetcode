package InterviewPlan;

/**
 * @author leapord
 * @since 2022/8/19
 */
public class Question1480 {
    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * <p>
     * 请返回 nums 的动态和。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/running-sum-of-1d-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] runningSum(int[] nums) {

        int size = nums.length;
        for (int i = 1; i < size; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
}
