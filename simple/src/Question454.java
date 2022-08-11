import java.util.HashMap;
import java.util.Map;

/**
 * @author leapord
 * @since 2022/8/11
 */
public class Question454 {
    /**
     * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
     * <p>
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/4sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }

        int count = 0;

        for (int i : nums3) {
            for (int j : nums4) {
                if (map.containsKey(0 - i - j)) {
                    count += map.get(0 - i - j);
                }
            }
        }
        return count;
    }
}
