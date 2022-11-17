package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Question792 {
    /**
     * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
     * <p>
     * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
     * <p>
     * 例如， “ace” 是 “abcde” 的子序列。
     * <p>
     * 1 <= s.length <= 5 * 104
     * <p>
     * 1 <= words.length <= 5000
     * <p>
     * 1 <= words[i].length <= 50
     * <p>
     * words[i]和 s 都只由小写字母组成。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-matching-subsequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-matching-subsequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numMatchingSubseq(String s, String[] words) {
        Deque<String>[] d = new Deque[26];
        for (int i = 0; i < 26; i++) {
            d[i] = new ArrayDeque<>();
        }
        for (String w : words) {
            d[w.charAt(0) - 'a'].add(w);
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            Deque<String> q = d[c - 'a'];
            for (int size = q.size(); size > 0; size--) {
                String word = q.pollFirst();
                if(word.length()==1){
                    ans++;
                }else{
                    d[word.charAt(1)-'a'].offer(word.substring(1));
                }
            }
        }
        return ans;
    }
}
