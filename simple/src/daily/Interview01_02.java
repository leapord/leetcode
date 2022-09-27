package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author leapord
 * @since 2022/9/27
 */
public class Interview01_02 {
    /**
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] hash = new int[26];

        // 组表
        for (Character key : s1.toCharArray()) {
            hash[key - 'a']++;
        }

        for (Character key : s2.toCharArray()) {
            int index = key - 'a';
            hash[index]--;
            if (hash[index] < 0) {
                return false;
            }
        }

        return true;
    }
}
