package offer;

import java.util.Arrays;

public class Offer45 {
    public String minNumber(int[] nums) {
        int length = nums.length;
        String[] strs = new String[length];
        for (int i = 0; i < length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        return String.join("", strs);
    }
}
