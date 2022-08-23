package question;

import java.util.Map;
import java.util.TreeMap;

public class Solution732 {
    class MyCalendarThree {
        TreeMap<Integer, Integer> cnt = null;

        public MyCalendarThree() {
            cnt = new TreeMap<>();
        }

        public int book(int start, int end) {
            int ans = 0;
            int makBook = 0;
            cnt.put(start, cnt.getOrDefault(start, 0) + 1);
            cnt.put(end, cnt.getOrDefault(end, 0) - 1);

            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int freq = entry.getValue();
                makBook += freq;
                ans = Math.max(makBook, ans);
            }
            return ans;
        }
    }
}
