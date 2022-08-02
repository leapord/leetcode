package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();
        for (int i : nums) {
            int count = ans.getOrDefault(i, 0);
            if (count > 1) {
                return i;
            } else {
                ans.put(i, count + 1);
            }
        }
        return -1;
    }
}
