package question;

/**
 * @author leapord
 * @since 2022/8/9
 */
public class Question242 {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-anagram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isAnagram(String s, String t) {

        int[] records = new int[26];

        for (int i = 0; i < s.length(); i++) {
            records[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            records[t.charAt(i) - 'a']--;
        }

        for (int record : records) {
            if (record != 0) {
                return false;
            }
        }

        return true;
    }
}
