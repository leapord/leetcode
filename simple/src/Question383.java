/**
 * @author leapord
 * @since 2022/8/11
 */
public class Question383 {
    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * <p>
     * 如果可以，返回 true ；否则返回 false 。
     * <p>
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/ransom-note
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 提示：
     * <p>
     * 1 <= ransomNote.length, magazine.length <= 105
     * ransomNote 和 magazine 由小写英文字母组成
     */

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] records = new int[26];

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        //记录所有字母出现频率
        for (int i = 0; i < magazine.length(); i++) {
            records[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            records[ransomNote.charAt(i) - 'a']--;

            if (records[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
