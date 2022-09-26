package daily;

/**
 * @author leapord
 * @since 2022/9/26
 */
public class Question55 {
    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标。
     */
    public boolean canJump(int[] nums) {
        int right = 0;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (i > right) {
                return false;
            }
            right = Math.max(right, i + nums[i]);
        }

        return true;
    }
}
