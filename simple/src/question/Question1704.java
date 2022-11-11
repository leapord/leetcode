package question;

public class Question1704 {
    /**
     * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
     * <p>
     * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
     * <p>
     * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/determine-if-string-halves-are-alike
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean halvesAreAlike(String s) {
        int length = s.length();
        String s1 = s.substring(0, length / 2);
        String s2 = s.substring(length / 2);
        String o = "aeiouAEIOU";
        int sum1 = 0;
        int sum2 = 0;

        for (char c : s1.toCharArray()) {
            if (o.indexOf(c) >= 0) {
                sum1++;
            }
        }

        for (char c : s2.toCharArray()) {
            if (o.indexOf(c) >= 0) {
                sum2++;
            }
        }

        return sum1 == sum2;
    }
}
