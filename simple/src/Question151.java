import java.util.Arrays;

/**
 * @author leapord
 * @since 2022/8/17
 */
public class Question151 {
    /**
     * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
     * <p>
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * <p>
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * <p>
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * <br/>
     * 示例 1：
     * <p>
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     * 示例 2：
     * <p>
     * 输入：s = "  hello world  "
     * 输出："world hello"
     * 解释：颠倒后的字符串中不能存在前导空格和尾随空格。
     * 示例 3：
     * <p>
     * 输入：s = "a good   example"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，颠倒后的字符串需要将单词间的空格减少到仅有一个。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 104
     * s 包含英文大小写字母、数字和空格 ' '
     * s 中 至少存在一个 单词
     *  
     * <p>
     * 进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-words-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int length = chars.length;

        int fast = length - 1;
        int slow = length - 1;

        // 首先找到最后一个不为空格的字符
        while (chars[fast] == ' ') {
            fast--;
            slow--;
        }

        while (fast >= 0) {
            //先找到单词
            while (fast >= 0 && chars[fast] != ' ') {
                fast--;
            }

            sb.append(s.substring(fast + 1, slow + 1));

            // 连续空格移动 题目中要求多个空格仅仅保留一个
            while (fast >= 0 && chars[fast] == ' ') {
                fast--;
                slow = fast;
            }
            // 补全空格，注意最后一定会多出一个，返回结果直接删除
            sb.append(' ');
        }

        return sb.substring(0, sb.length() - 1);
    }
}
