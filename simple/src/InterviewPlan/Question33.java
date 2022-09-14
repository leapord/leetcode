package InterviewPlan;

/**
 * @author leapord
 * @since 2022/9/14
 */
public class Question33 {
    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * <p>
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * <p>
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * <p>
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int search(int[] nums, int target) {
        //  4 5 6 7 8 0 1 2 3
        return searchPosition(nums, 0, nums.length - 1, target);
    }

    private int searchPosition(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        int leftValue = nums[left];
        int rightValue = nums[right];
        int midValue = nums[mid];
        if (leftValue == target) {
            return left;
        }
        if (rightValue == target) {
            return right;
        }
        if (midValue == target) {
            return mid;
        }

        if (midValue > leftValue) {
            if (target > leftValue && target < midValue) {
                return searchPosition(nums, left + 1, mid - 1, target);
            } else {
                return searchPosition(nums, mid + 1, right - 1, target);
            }
        } else {
            if (target > midValue && target < rightValue) {
                return searchPosition(nums, mid + 1, right - 1, target);
            } else {
                return searchPosition(nums, left + 1, mid - 1, target);
            }
        }
    }
}
