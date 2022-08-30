package InterviewPlan;

/**
 * @author leapord
 * @since 2022/8/30
 */
public class Question424 {
    /**
     * 给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
     * <p>
     * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ABAB", k = 2
     * 输出：4
     * 解释：用两个'A'替换为两个'B',反之亦然。
     * 示例 2：
     * <p>
     * 输入：s = "AABABBA", k = 1
     * 输出：4
     * 解释：
     * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
     * 子串 "BBBB" 有最长重复字母, 答案为 4。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 105
     * s 仅由大写英文字母组成
     * 0 <= k <= s.length
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-repeating-character-replacement
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int characterReplacement(String s, int k) {
        int[] chars = new int[26];
        int length = s.length();
        int max = 0;
        int left = 0;
        int right = 0;

        while (right < length) {
            chars[s.charAt(right) - 'A']++;
            max = Math.max(max, chars[s.charAt(right) - 'A']);

            if (right - left + 1 - max > k) {
                chars[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }

        return right - left;
    }
}
