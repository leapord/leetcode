package question;

/**
 * @author leapord
 * @since 2022/8/15
 */
public class Question541 {
    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     * <p>
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-string-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int length = s.length();

        for (int i = 0; i < length; i += 2 * k) {
            int start = i;
            int end = Math.min(length - 1, start + k - 1);

            while (start < end) {
                chars[start] ^= chars[end];
                chars[end] ^= chars[start];
                chars[start] ^= chars[end];
                start++;
                end--;
            }
        }

        return String.valueOf(chars);
    }
}
