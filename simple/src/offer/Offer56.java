package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer56 {

    public int[] singleNumbers(int[] nums) {
        int x = 0;
        int y = 0;
        int n = 0;
        int m = 1;

        for (int num : nums) {
            n ^= num;
        }

        while ((n & m) == 0) {
            m <<= 1;
        }

        for (int num : nums) {
            if ((num & m) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int key : map.keySet()) {
            if(map.get(key) == 1){
                ans = key;
                break;
            }
        }
        return ans;
    }
}
