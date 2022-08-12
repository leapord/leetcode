import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leapord
 * @since 2022/8/12
 */
public class Question15 {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[]
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 单循环和双指针
        //先排序处理
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {

            if (nums[i] > 0) {
                return res;
            }

            //去重处理
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                // 指针收缩
                if (sum > 0) {
                    // 右指针收缩
                    right--;
                } else if (sum < 0) {
                    //左指针收缩
                    left++;
                } else {
                    // 找到答案
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 找到元素要先进行一次完整三元组去重
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    right--;
                    left++;
                }
            }
        }
        return res;
    }
}
