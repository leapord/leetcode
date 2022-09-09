package InterviewPlan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leapord
 * @since 2022/9/8
 */
public class Question2131 {
    /**
     * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
     * <p>
     * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
     * <p>
     * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
     * <p>
     * 回文串 指的是从前往后和从后往前读一样的字符串。
     * <p>
     *  
     * 提示：
     * <p>
     * 1 <= words.length <= 105
     * words[i].length == 2
     * words[i] 仅包含小写英文字母。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-palindrome-by-concatenating-two-letter-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int longestPalindrome(String[] words) {
        int res = 0;
        boolean mid = false;

        Map<String, Integer> cnt = new HashMap<>();

        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }

        for (String word : cnt.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();
            Integer count = cnt.getOrDefault(word, 0);

            if (word.equals(rev)) {
                if (count % 2 == 1) {
                    mid = true;
                }
                res += 2 * (count / 2 * 2);
            } else if (word.compareTo(rev) > 0) {
                res += 4 * Math.min(cnt.getOrDefault(word, 0), cnt.getOrDefault(rev, 0));
            }
        }

        if (mid) {
            res += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        Question2131 test = new Question2131();
        int i = test.longestPalindrome(new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"});
        System.out.println(i);
    }
}
