package question;

/**
 * @author leapord
 * @since 2022/11/13
 */
public class Question791 {
    /**
     * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
     * <p>
     * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
     * <p>
     * 返回 满足这个性质的 s 的任意排列 。
     * <p>
     * 提示:
     * <p>
     * 1 <= order.length <= 26
     * <p>
     * 1 <= s.length <= 200
     * <p>
     * order 和 s 由小写英文字母组成
     * <p>
     * order 中的所有字符都 不同
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/custom-sort-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/custom-sort-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String customSortString(String order, String s) {
        StringBuilder ans = new StringBuilder();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            ++freq[ch - 'a'];
        }

        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            while (freq[ch - 'a'] > 0) {
                ans.append(ch);
                freq[ch - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                ans.append((char) (i + 'a'));
                freq[i]--;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Question791 question791 = new Question791();
        String result = question791.customSortString("cba", "abcd");
        System.out.println(result);
    }
}
