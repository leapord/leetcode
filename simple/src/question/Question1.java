package question;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leapord
 * @since 2022/8/5
 */
public class Question1 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] ans = new int[0];
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans = new int[]{i, map.get(target - nums[i])};
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
