package question;

import java.util.HashSet;
import java.util.Set;

public class Question1684 {

    /**
     * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
     * <p>
     * 请你返回 words 数组中 一致字符串 的数目。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/count-the-number-of-consistent-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (Character chaz : allowed.toCharArray()) {
            set.add(chaz);
        }
        for (String word : words) {
            boolean flag = true;
            for (Character chaz : word.toCharArray()) {
                if(!set.contains(chaz)){
                    flag=false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}
