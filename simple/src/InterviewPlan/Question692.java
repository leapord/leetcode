package InterviewPlan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author leapord
 * @since 2022/9/2
 */
public class Question692 {
    /**
     * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
     * <p>
     * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * 输出: ["i", "love"]
     * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
     * 注意，按字母顺序 "i" 在 "love" 之前。
     * 示例 2：
     * <p>
     * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * 输出: ["the", "is", "sunny", "day"]
     * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
     * 出现次数依次为 4, 3, 2 和 1 次。
     *  
     * <p>
     * 注意：
     * <p>
     * 1 <= words.length <= 500
     * 1 <= words[i] <= 10
     * words[i] 由小写英文字母组成。
     * k 的取值范围是 [1, 不同 words[i] 的数量]
     *  
     * <p>
     * 进阶：尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/top-k-frequent-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue =
                new PriorityQueue<>((o1, o2) -> o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue());

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            ans.add(queue.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }
}
