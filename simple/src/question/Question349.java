package question;

import java.util.HashSet;
import java.util.Set;

/**
 * @author leapord
 * @since 2022/8/10
 */
public class Question349 {
    /**
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // 不存在交集情况
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }

        return ans.stream().mapToInt(x -> x).toArray();
    }
}
