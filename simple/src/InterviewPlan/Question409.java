package InterviewPlan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leapord
 * @since 2022/8/23
 */
public class Question409 {
    /**
     * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
     * <p>
     * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入:s = "abccccdd"
     * 输出:7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * 示例 2:
     * <p>
     * 输入:s = "a"
     * 输入:1
     *  
     * <p>
     * 提示:
     * <p>
     * 1 <= s.length <= 2000
     * s 只由小写 和/或 大写英文字母组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int longestPalindrome(String s) {
        int res = 0;
        int sed = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (Character chaz : s.toCharArray()) {
            map.put(chaz, map.getOrDefault(chaz, 0) + 1);
        }

        for (Character key : map.keySet()) {
            Integer count = map.get(key);
            int delta = count % 2;
            if (delta == 1) {
                res += count - delta;
                sed = 1;
            } else {
                res += count;
            }
        }

        return res + sed;
    }
}
