package org.leapord;

/**
 * @author leapord
 * @since 2022/8/1
 */
public class Question35 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int searchInsert(int[] nums, int target) {
        // 注意题目要求，时间复杂度必须是 O(log n) , 在查找算法中满足要求主要就是二分查找
        int ans = nums.length;
        int left = 0;
        int right = ans - 1;

        // 本题是查找插入的位置，终止条件不是单调递增，而是要找到具体位置 ，当left=right后才算完全查找完
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                // [mid , right]
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
