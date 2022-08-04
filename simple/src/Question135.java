import java.util.Arrays;

/**
 * @author leapord
 * @since 2022/8/4
 */
public class Question135 {
    /**
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     * <p>
     * 你需要按照以下要求，给这些孩子分发糖果：
     * <p>
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/candy
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int candy(int[] ratings) {
        /**
         * 两次遍历解决 题目要求 评分高的孩子比左右都要搞，必须满足 ratings[i] > ratings[i+1] 右侧
         *  ratings[i] > ratings[i-1] 得到的糖果都多
         */

        int length = ratings.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        //先填充左规则
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // 左规则已经找出右侧最后一个最大值，同理右规则会找出左侧最大值，最终答案必定有个最大值作为最大开始计数值
        int res = left[length - 1];
        //再填充右规则
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            res += Math.max(left[i], right[i]);
        }

        return res;
    }
}
