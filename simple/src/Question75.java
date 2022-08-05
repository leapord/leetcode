/**
 * @author leapord
 * @since 2022/8/5
 */
public class Question75 {
    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 必须在不使用库的sort函数的情况下解决这个问题。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sort-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public void sortColors(int[] nums) {

        // 依据题目，0需要在左边，2需要在最右边，利用双指针，单次遍历整个数据，左右双互换即可
        int length = nums.length;
        if (length < 2) {
            return;
        }
        int left = 0;
        int right = length - 1;

        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                //等于0的颜色全部放到最左边
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            }
            if (nums[i] == 2) {
                //等于0的颜色全部放到最左边
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
                if (nums[i] != 1) {
                    i--;
                }
            }
        }

    }
}
