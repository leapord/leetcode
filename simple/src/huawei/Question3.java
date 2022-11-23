package huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question3 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 滑动窗口典型案例
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int rightKey = -1; // 右侧指针还没有开始移动
        Set<Character> set = new HashSet<>();
        int lenght = s.length();
        for (int i = 0; i < lenght; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rightKey + 1 < lenght && !set.contains(s.charAt(rightKey + 1))) {
                set.add(s.charAt(rightKey + 1));
                rightKey++;
            }
            max = Math.max(max, rightKey - i + 1);
        }
        return max;
    }
}
