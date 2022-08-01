package org.leapord;

/**
 * @author leapord
 * @since 2022/8/1
 */
public class Question704 {
    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 简单二分查找，普通二分查找算法即可解决问题，注意 mid = (left + right) / 2 无解 bug
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
