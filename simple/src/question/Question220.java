package question;

import java.util.Set;
import java.util.TreeSet;

public class Question220 {
    /**
     * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，
     * 同时又满足 abs(i - j) <= k 。
     * <p>
     * 如果存在则返回 true，不存在返回 false。
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 2 * 104
     * <p>
     * -231 <= nums[i] <= 231 - 1
     * <p>
     * 0 <= k <= 104
     * <p>
     * 0 <= t <= 231 - 1
     *
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/contains-duplicate-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/contains-duplicate-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            Integer cell = set.ceiling(nums[i] - t);
            if(cell!=null && cell<=(nums[i]+t)){
                return true;
            }
            set.add(nums[i]);
            if(i>=k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
