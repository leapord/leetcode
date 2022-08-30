package InterviewPlan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leapord
 * @since 2022/8/30
 */
public class Question438 {
    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     *  示例 2:
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     *  
     * <p>
     * 提示:
     * <p>
     * 1 <= s.length, p.length <= 3 * 104
     * s 和 p 仅包含小写字母
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> findAnagrams(String s, String p) {
        // 滑动窗口
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) {
            cnt[c]++;
        }

        int low = 0;
        int high = 0;
        List<Integer> ans = new ArrayList<>();

        while (high < s.length()) {
            if (cnt[s.charAt(high)] > 0) {
                cnt[s.charAt(high)]--;
                high++;
                if (high - low == p.length()) {
                    ans.add(low);
                }
            } else {
                cnt[s.charAt(low)]++;
                low++;
            }
        }

        return ans;
    }
}
