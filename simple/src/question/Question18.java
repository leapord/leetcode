package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leapord
 * @since 2022/8/12
 */
public class Question18 {
    /**
     * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     * <p>
     * 0 <= a, b, c, d < n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,2,2,2], target = 8
     * 输出：[[2,2,2,2]]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            // 剪枝处理
            if (nums[i] > target && nums[i] >= 0 && target >= 0) {
                break;
            }

            // 对外层i 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < length; j++) {
                // 剪枝处理
                if (nums[i] + nums[j] > target && nums[i] + nums[j]  >= 0 && target >= 0) {
                    break;
                }
                // 内层去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;

                while (right > left) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {

                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

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
        }
        return res;
    }
}
