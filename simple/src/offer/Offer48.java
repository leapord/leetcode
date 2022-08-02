package offer;

import java.util.HashSet;
import java.util.Set;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int right = -1;
        int length = s.length();
        int ans = 0;
        for(int left = 0;left < length;left++){
            if(left !=0){
                set.remove(s.charAt(left-1));
            }
            while(right+1<length && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
